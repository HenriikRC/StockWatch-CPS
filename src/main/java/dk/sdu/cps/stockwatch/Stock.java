package dk.sdu.cps.stockwatch;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class Stock {

    @Id
    @GeneratedValue
    private Long id;
    private String name, symbol;
    @OneToMany(mappedBy = "stock", fetch = FetchType.LAZY)
    private List<StockTimeSeries> stockTimeSeries;

}
