package com.qindel.test.service;

import com.qindel.test.dto.PriceDTO;
import com.qindel.test.dto.PriceResponseDTO;

public interface PriceService {

    PriceResponseDTO getPrice(PriceDTO priceDTO, Integer limit, Integer offset);
    
}
