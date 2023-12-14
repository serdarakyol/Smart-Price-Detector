package com.qindel.test.config;

import java.time.Instant;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qindel.test.entity.Brand;
import com.qindel.test.entity.Price;
import com.qindel.test.repository.PriceRepository;

@Configuration
public class PriceConfig {
    @Bean
    CommandLineRunner commandLineRunner(PriceRepository priceRepository) {
        return args -> {
            Brand brand = new Brand(1, "ZARA", null);
            Price p1 = Price.builder().productId(35455).priority(0).price((float) 35.50).currency("EUR")
                    .startDate(Instant.parse("2020-06-14T00:00:00Z")).endDate(Instant.parse("2020-12-31T23:59:59Z"))
                    .priceList(1).brand(brand).build();

            Price p2 = Price.builder().productId(35455).priority(1).price((float) 25.45).currency("EUR")
                    .startDate(Instant.parse("2020-06-14T15:00:00Z")).endDate(Instant.parse("2020-06-14T18:30:00Z"))
                    .priceList(2).brand(brand).build();

            Price p3 = Price.builder().productId(35455).priority(1).price((float) 30.50).currency("EUR")
                    .startDate(Instant.parse("2020-06-15T00:00:00Z")).endDate(Instant.parse("2020-06-15T11:00:00Z"))
                    .priceList(3).brand(brand).build();

            Price p4 = Price.builder().productId(35455).priority(1).price((float) 38.95).currency("EUR")
                    .startDate(Instant.parse("2020-06-15T16:00:00Z")).endDate(Instant.parse("2020-12-31T23:59:59Z"))
                    .priceList(4).brand(brand).build();

            priceRepository.saveAll(List.of(p1, p2, p3, p4));
        };
    };
}
