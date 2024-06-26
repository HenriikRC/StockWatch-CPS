package dk.sdu.cps.stockwatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockWatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockWatchApplication.class, args);
    }

}
