package dk.sdu.cps.stockwatch.service;

import dk.sdu.cps.stockwatch.model.StockResponse;
import dk.sdu.cps.stockwatch.model.StockTimeSeries;
import dk.sdu.cps.stockwatch.service.StockTimeSeriesService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Timestamp;
import java.util.Map;

@Service
public class StockApi {

    @Value("${API_KEY}")
    private String apiKey;
    private RestTemplate restTemplate = new RestTemplate();
    private StockTimeSeriesService stockTimeSeriesService;

    public StockApi(StockTimeSeriesService stockTimeSeriesService) {
        this.stockTimeSeriesService = stockTimeSeriesService;
    }


    @PostConstruct
    public void getStockData() {
        String url = UriComponentsBuilder.fromHttpUrl("https://www.alphavantage.co")
                .path("/query")
                .queryParam("function", "TIME_SERIES_INTRADAY")
                .queryParam("symbol", "AAPL")
                .queryParam("interval", "1min")
                .queryParam("apikey", apiKey)
                .toUriString();
        StockResponse response = restTemplate.getForObject(url, StockResponse.class);
        System.out.println(response);
        assert response != null;
        for(Map.Entry<Timestamp, StockTimeSeries> entry : response.getTimeSeries().entrySet()) {
            StockTimeSeries stockTimeSeries = entry.getValue();
            stockTimeSeriesService.create(stockTimeSeries.getOpen(), stockTimeSeries.getHigh(), stockTimeSeries.getLow(), stockTimeSeries.getClose(), stockTimeSeries.getVolume(), entry.getKey());
        }
    }

}
