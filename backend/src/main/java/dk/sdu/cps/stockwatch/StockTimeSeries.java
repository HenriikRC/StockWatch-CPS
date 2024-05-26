package dk.sdu.cps.stockwatch;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class StockTimeSeries {
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("1. open")
    private double open;
    @JsonProperty("2. high")
    private double high;
    @JsonProperty("3. low")
    private double low;
    @JsonProperty("4. close")
    private double close;
    @JsonProperty("5. volume")
    private long volume;
    @ManyToOne
    private Stock stock;
    private Timestamp timeStamp;
}
