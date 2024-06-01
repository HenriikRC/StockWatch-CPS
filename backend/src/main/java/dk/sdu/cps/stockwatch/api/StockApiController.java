package dk.sdu.cps.stockwatch.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stockapi")
@CrossOrigin
public class StockApiController {
    private final StockApi stockApi;

    public StockApiController(StockApi stockApi) {
        this.stockApi = stockApi;
    }

    @PostMapping("/update")
    public void updateStocks() {
        stockApi.getStockData();
    }

}
