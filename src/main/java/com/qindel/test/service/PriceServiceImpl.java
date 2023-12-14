package com.qindel.test.service;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qindel.test.dto.PriceDTO;
import com.qindel.test.dto.PriceResponseDTO;
import com.qindel.test.entity.Price;
import com.qindel.test.exception.PriceException;
import com.qindel.test.mapper.PriceMapper;
import com.qindel.test.repository.PriceRepository;
import com.qindel.test.response.ResponseEnum;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    @Override
    public PriceResponseDTO getPrice(PriceDTO priceDTO) {

        List<Price> prices = priceRepository
                .findByProductIdAndBrand_IdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                        priceDTO.getProductId(), priceDTO.getBrandId(), Instant.parse(priceDTO.getDate()),
                        Instant.parse(priceDTO.getDate()));

        // Get highest priority Price
        Price prioritisedPrise = prices.stream().max(Comparator.comparingInt(Price::getPriority))
                .orElseThrow(() -> new PriceException(ResponseEnum.NOT_FOUND));

        return priceMapper.mapperPriceToResponseDTO(prioritisedPrise);
    }

}
