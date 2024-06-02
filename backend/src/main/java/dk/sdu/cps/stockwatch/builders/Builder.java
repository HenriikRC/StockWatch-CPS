package dk.sdu.cps.stockwatch.builders;

import dk.sdu.cps.stockwatch.model.Stock;

import java.sql.Timestamp;

public interface Builder {
    StockBuilder setOpen(double open);
    StockBuilder setHigh(double high);
    StockBuilder setLow(double low);
    StockBuilder setClose(double close);
    StockBuilder setVolume(long volume);
    StockBuilder setStock(Stock stock);
    StockBuilder setTimeStamp(Timestamp timestamp);
}
