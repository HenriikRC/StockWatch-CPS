package dk.sdu.cps.stockwatch.repository;

import dk.sdu.cps.stockwatch.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long>{
}
