package dk.sdu.cps.stockwatch.builders;

import dk.sdu.cps.stockwatch.model.Stock;
import dk.sdu.cps.stockwatch.model.StockTimeSeries;
import dk.sdu.cps.stockwatch.service.StockService;

import java.sql.Timestamp;

public class StockBuilder implements Builder{
    private double open;
    private double high;
    private double low;
    private double close;
    private long volume;
    private Stock stock;
    private Timestamp timestamp;
    private StockService stockService;

    public StockBuilder() {
        this.open = 100;
        this.high = 100;
        this.low = 100;
        this.close = 100;
        this.volume = 100;
        Stock stock = new Stock();
        stock.setSymbol("AAPL");
        stock.setName("Apple Inc.");
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public StockBuilder setOpen(double open) {
        this.open = open;
        return this;
    }

    public StockBuilder setHigh(double high) {
        this.high = high;
        return this;
    }

    public StockBuilder setLow(double low) {
        this.low = low;
        return this;
    }

    public StockBuilder setClose(double close) {
        this.close = close;
        return this;
    }

    public StockBuilder setVolume(long volume) {
        this.volume = volume;
        return this;
    }

    public StockBuilder setStock(Stock stock) {
        this.stock = stock;
        return this;
    }

    public StockBuilder setTimeStamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public StockTimeSeries build() {
        StockTimeSeries stockTimeSeries = new StockTimeSeries();
        stockTimeSeries.setOpen(open);
        stockTimeSeries.setHigh(high);
        stockTimeSeries.setLow(low);
        stockTimeSeries.setClose(close);
        stockTimeSeries.setVolume(volume);
        stockTimeSeries.setStock(stock);
        stockTimeSeries.setTimeStamp(timestamp);
        return stockTimeSeries;
    }
}
