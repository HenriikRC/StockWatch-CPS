package dk.sdu.cps.stockwatch.builders;

import dk.sdu.cps.stockwatch.model.Stock;
import dk.sdu.cps.stockwatch.model.StockTimeSeries;
import dk.sdu.cps.stockwatch.service.StockService;

import java.sql.Timestamp;

public class StockBuilder implements Builder{
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Double volume;
    private Stock stock;
    private Timestamp timestamp;
    private StockService stockService;

    public StockBuilder() {
        this.open = 100.0;
        this.high = 100.0;
        this.low = 100.0;
        this.close = 100.0;
        this.volume = 100.0;
        Stock stock = new Stock();
        stock.setSymbol("AAPL");
        stock.setName("Apple Inc.");
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public StockBuilder setOpen(Double open) {
        this.open = open;
        return this;
    }

    public StockBuilder setHigh(Double high) {
        this.high = high;
        return this;
    }

    public StockBuilder setLow(Double low) {
        this.low = low;
        return this;
    }

    public StockBuilder setClose(Double close) {
        this.close = close;
        return this;
    }

    public StockBuilder setVolume(Double volume) {
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
