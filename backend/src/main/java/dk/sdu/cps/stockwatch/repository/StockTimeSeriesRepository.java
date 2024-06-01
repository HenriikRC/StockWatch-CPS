package dk.sdu.cps.stockwatch.repository;

import dk.sdu.cps.stockwatch.model.StockTimeSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTimeSeriesRepository extends JpaRepository<StockTimeSeries, Long>{
}
