package com.qindel.test.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.qindel.test.dto.PriceResponseDTO;
import com.qindel.test.entity.Price;

@Component
public class PriceMapper {

    public PriceResponseDTO mapperPriceToResponseDTO(Price price) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(price, PriceResponseDTO.class);
    }

}
