package com.qindel.test.controller;

import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qindel.test.dto.PriceDTO;
import com.qindel.test.dto.PriceResponseDTO;
import com.qindel.test.response.ResponseEnum;
import com.qindel.test.response.ResponsePrice;
import com.qindel.test.service.PriceService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("0.0.1/test")
@Tag(name = "Price MODULE", description = "Prices depending on time")
public class PriceController {

    private final PriceService priceService;

    @GetMapping
    public ResponsePrice<PriceResponseDTO> getPrices(@RequestBody PriceDTO priceDTO,
            @RequestParam(name = "limit", required = false) Integer limit,
            @RequestParam(name = "offset", required = false) Integer offset) {

        return ResponsePrice.<PriceResponseDTO>builder().data(priceService.getPrice(priceDTO, limit, offset))
                .statusCode(ResponseEnum.SUCCESS.getStatusCode())
                .statusMessage(ResponseEnum.SUCCESS.getStatusMessage())
                .timestamp(Instant.now().toString()).build();
    }

}
