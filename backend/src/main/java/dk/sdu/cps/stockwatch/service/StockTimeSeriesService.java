package dk.sdu.cps.stockwatch.service;

import dk.sdu.cps.stockwatch.builders.StockBuilder;
import dk.sdu.cps.stockwatch.model.Stock;
import dk.sdu.cps.stockwatch.model.StockTimeSeries;
import dk.sdu.cps.stockwatch.repository.StockTimeSeriesRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class StockTimeSeriesService {

    private final StockTimeSeriesRepository stockTimeSeriesRepository;
    private final StockService stockService;
    private Stock aapl;

    public StockTimeSeriesService(StockTimeSeriesRepository stockTimeSeriesRepository,
                                  StockService stockService) {
        this.stockTimeSeriesRepository = stockTimeSeriesRepository;
        this.stockService = stockService;
    }
    @PostConstruct
    public void init() {
        aapl = stockService.create("AAPL", "Apple Inc.");
    }

    /*
    public StockTimeSeries create(double open, double high, double low, double close, long volume, Timestamp timestamp) {
        StockTimeSeries stockTimeSeries = new StockTimeSeries();
        stockTimeSeries.setOpen(open);
        stockTimeSeries.setHigh(high);
        stockTimeSeries.setLow(low);
        stockTimeSeries.setClose(close);
        stockTimeSeries.setVolume(volume);
        stockTimeSeries.setStock(aapl);
        stockTimeSeries.setTimeStamp(timestamp);
        return stockTimeSeriesRepository.save(stockTimeSeries);
    }
    */
    public StockTimeSeries create(double open, double high, double low, double close, long volume, Timestamp timestamp) {
        return stockTimeSeriesRepository.save(new StockBuilder()
                .setOpen(open)
                .setHigh(high)
                .setLow(low)
                .setClose(close)
                .setVolume(volume)
                .setStock(aapl)
                .setTimeStamp(timestamp)
                .build());
    }
}
