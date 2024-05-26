package dk.sdu.cps.stockwatch;

import org.springframework.stereotype.Service;

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
}
