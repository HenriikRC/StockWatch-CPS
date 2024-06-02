package dk.sdu.cps.stockwatch.service;

import dk.sdu.cps.stockwatch.model.Stock;
import dk.sdu.cps.stockwatch.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

        private final StockRepository stockRepository;

        public StockService(StockRepository stockRepository) {
            this.stockRepository = stockRepository;

        }

        public Stock create(String symbol, String name) {
            Stock stock = new Stock();
            stock.setSymbol(symbol);
            stock.setName(name);
            return stockRepository.save(stock);
        }

    public Optional<Stock> getStock(Long stockId) {
        return stockRepository.findById(stockId);
    }

    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }
}
