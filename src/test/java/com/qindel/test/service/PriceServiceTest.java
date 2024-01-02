package com.qindel.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qindel.test.dto.PriceDTO;
import com.qindel.test.dto.PriceResponseDTO;
import com.qindel.test.entity.Brand;
import com.qindel.test.entity.Price;
import com.qindel.test.exception.PriceException;
import com.qindel.test.mapper.PriceMapper;
import com.qindel.test.repository.PriceRepository;
import com.qindel.test.response.ResponseEnum;
import com.qindel.test.utils.Filter;

@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {

    @InjectMocks
    private PriceServiceImpl priceService;

    @Spy
    private PriceMapper priceMapper;

    @Mock
    private PriceRepository priceRepository;

    List<Price> prices;
    Filter filter;

    @BeforeEach
    void init() {
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
        prices = new ArrayList<>();
        prices.addAll(List.of(p1, p2, p3, p4));

        Integer offset = 0;
        Integer limit = 2;
        filter = new Filter(limit, offset);
    }

    @Test
    void testGetPriceForDay14Hour10() {
        // Given
        Price price = prices.get(0);
        PriceDTO priceDTO = PriceDTO.builder().productId(price.getProductId()).brandId(price.getBrand().getId())
                .date("2020-06-14T10:00:00Z").build();
        Instant date = Instant.parse(priceDTO.getDate());
        PriceResponseDTO expectedDto = PriceResponseDTO.builder().productId(price.getProductId())
                .brandId(price.getBrand().getId()).priceList(price.getPriceList())
                .startDate(price.getStartDate().toString()).endDate(price.getEndDate().toString())
                .price(price.getPrice()).build();
        when(priceRepository.findByProductIdAndBrand_IdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                priceDTO.getProductId(), priceDTO.getBrandId(), date, date, filter.getPageable()))
                .thenReturn(List.of(prices.get(0)));

        // When
        PriceResponseDTO actualDto = priceService.getPrice(priceDTO, filter.getLimit(), filter.getOffset());

        // Then
        assertEquals(expectedDto, actualDto);
    }

    @Test
    void testGetPriceForDay14Hour16() {
        // Given
        Price price = prices.get(1);
        PriceDTO priceDTO = PriceDTO.builder().productId(price.getProductId()).brandId(price.getBrand().getId())
                .date("2020-06-14T16:00:00Z").build();
        Instant date = Instant.parse(priceDTO.getDate());
        PriceResponseDTO expectedDto = PriceResponseDTO.builder().productId(price.getProductId())
                .brandId(price.getBrand().getId()).priceList(price.getPriceList())
                .startDate(price.getStartDate().toString()).endDate(price.getEndDate().toString())
                .price(price.getPrice()).build();
        when(priceRepository.findByProductIdAndBrand_IdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                priceDTO.getProductId(), priceDTO.getBrandId(), date, date, filter.getPageable()))
                .thenReturn(List.of(prices.get(1), prices.get(0)));

        // When
        PriceResponseDTO actualDto = priceService.getPrice(priceDTO, filter.getLimit(), filter.getOffset());

        // Then
        assertEquals(expectedDto, actualDto);
    }

    @Test
    void testGetPriceForDay14Hour21() {
        // Given
        Price price = prices.get(0);
        PriceDTO priceDTO = PriceDTO.builder().productId(price.getProductId()).brandId(price.getBrand().getId())
                .date("2020-06-14T21:00:00Z").build();
        Instant date = Instant.parse(priceDTO.getDate());
        PriceResponseDTO expectedDto = PriceResponseDTO.builder().productId(price.getProductId())
                .brandId(price.getBrand().getId()).priceList(price.getPriceList())
                .startDate(price.getStartDate().toString()).endDate(price.getEndDate().toString())
                .price(price.getPrice()).build();
        when(priceRepository.findByProductIdAndBrand_IdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                priceDTO.getProductId(), priceDTO.getBrandId(), date, date, filter.getPageable())).thenReturn(List.of(prices.get(0)));

        // When
        PriceResponseDTO actualDto = priceService.getPrice(priceDTO, filter.getLimit(), filter.getOffset());

        // Then
        assertEquals(expectedDto, actualDto);
    }

    @Test
    void testGetPriceForDay15Hour10() {
        // Given
        Price price = prices.get(2);
        PriceDTO priceDTO = PriceDTO.builder().productId(price.getProductId()).brandId(price.getBrand().getId())
                .date("2020-06-15T21:00:00Z").build();
        PriceResponseDTO expectedDto = PriceResponseDTO.builder().productId(price.getProductId())
                .brandId(price.getBrand().getId()).priceList(price.getPriceList())
                .startDate(price.getStartDate().toString()).endDate(price.getEndDate().toString())
                .price(price.getPrice()).build();
        Instant date = Instant.parse(priceDTO.getDate());
        when(priceRepository.findByProductIdAndBrand_IdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                priceDTO.getProductId(), priceDTO.getBrandId(), date, date, filter.getPageable()))
                .thenReturn(List.of(prices.get(2), prices.get(0)));

        // When
        PriceResponseDTO actualDto = priceService.getPrice(priceDTO, filter.getLimit(), filter.getOffset());

        // Then
        assertEquals(expectedDto, actualDto);
    }

    @Test
    void testGetPriceForDay16Hour21() {
        // Given
        Price price = prices.get(3);
        PriceDTO priceDTO = PriceDTO.builder().productId(price.getProductId()).brandId(price.getBrand().getId())
                .date("2020-06-16T21:00:00Z").build();
        PriceResponseDTO expectedDto = PriceResponseDTO.builder().productId(price.getProductId())
                .brandId(price.getBrand().getId()).priceList(price.getPriceList())
                .startDate(price.getStartDate().toString()).endDate(price.getEndDate().toString())
                .price(price.getPrice()).build();
        Instant date = Instant.parse(priceDTO.getDate());
        when(priceRepository.findByProductIdAndBrand_IdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                priceDTO.getProductId(), priceDTO.getBrandId(), date, date, filter.getPageable()))
                .thenReturn(List.of(prices.get(3), prices.get(0)));

        // When
        PriceResponseDTO actualDto = priceService.getPrice(priceDTO, filter.getLimit(), filter.getOffset());

        // Then
        assertEquals(expectedDto, actualDto);
    }

    @Test
    void testGetPriceEmptyList_ThenNotFoundError() {
        // Given
        Price price = prices.get(3);
        PriceDTO priceDTO = PriceDTO.builder().productId(price.getProductId()).brandId(price.getBrand().getId())
                .date("2020-06-14T21:00:00Z").build();
        Instant date = Instant.parse(priceDTO.getDate());
        when(priceRepository.findByProductIdAndBrand_IdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                priceDTO.getProductId(), priceDTO.getBrandId(), date, date, filter.getPageable()))
                .thenReturn(List.of());

        // When
        PriceException exception = assertThrows(PriceException.class, () -> {
            priceService.getPrice(priceDTO, filter.getLimit(), filter.getOffset());
        });

        // Then
        assertEquals(ResponseEnum.NOT_FOUND, exception.getException());
    }

}
