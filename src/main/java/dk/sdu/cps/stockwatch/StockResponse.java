package dk.sdu.cps.stockwatch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Map;

@Data
public class StockResponse {
    @JsonProperty("Meta Data")
    private StockMetaData metaData;
    @JsonProperty("Time Series (1min)")
    private Map<Timestamp, StockTimeSeries> timeSeries;
}
