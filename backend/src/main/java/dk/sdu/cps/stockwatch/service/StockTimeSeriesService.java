package dk.sdu.cps.stockwatch.service;

import dk.sdu.cps.stockwatch.builders.StockBuilder;
import dk.sdu.cps.stockwatch.model.Stock;
import dk.sdu.cps.stockwatch.model.StockTimeSeries;
import dk.sdu.cps.stockwatch.repository.StockTimeSeriesRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockTimeSeriesService {

    private final StockTimeSeriesRepository stockTimeSeriesRepository;
    private final StockService stockService;

    public StockTimeSeriesService(StockTimeSeriesRepository stockTimeSeriesRepository,
                                  StockService stockService) {
        this.stockTimeSeriesRepository = stockTimeSeriesRepository;
        this.stockService = stockService;

    }

    public StockTimeSeries create(double open, double high, double low, double close, long volume, Timestamp timestamp, Stock stock) {
        return stockTimeSeriesRepository.save(new StockBuilder()
                .setOpen(open)
                .setHigh(high)
                .setLow(low)
                .setClose(close)
                .setVolume(volume)
                .setStock(stock)
                .setTimeStamp(timestamp)
                .build());
    }
}
