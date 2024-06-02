package dk.sdu.cps.stockwatch.builders;

import dk.sdu.cps.stockwatch.model.Stock;

import java.sql.Timestamp;

public interface Builder {
    StockBuilder setOpen(Double open);
    StockBuilder setHigh(Double high);
    StockBuilder setLow(Double low);
    StockBuilder setClose(Double close);
    StockBuilder setVolume(Double volume);
    StockBuilder setStock(Stock stock);
    StockBuilder setTimeStamp(Timestamp timestamp);
}
