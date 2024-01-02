package com.qindel.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qindel.test.dto.PriceDTO;
import com.qindel.test.dto.PriceResponseDTO;
import com.qindel.test.response.ResponsePrice;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetPricesForDay14Hour10() throws Exception {
        // Given
        PriceDTO requestBody = new PriceDTO();
        requestBody.setDate("2020-06-14T10:00:00Z");
        requestBody.setProductId(35455);
        requestBody.setBrandId(1);

        PriceResponseDTO expectedResult = PriceResponseDTO.builder().productId(requestBody.getProductId())
                .brandId(requestBody.getBrandId()).price((float) 35.50).startDate("2020-06-14T00:00:00Z")
                .endDate("2020-12-31T23:59:59Z").priceList(1).build();

        // When
        MvcResult result = this.mockMvc.perform(get("/0.0.1/test")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Then
        String stringResponse = result.getResponse().getContentAsString();
        ResponsePrice<PriceResponseDTO> actualResponse = objectMapper.readValue(stringResponse,
                new TypeReference<ResponsePrice<PriceResponseDTO>>() {
                });
        assertEquals(actualResponse.getStatusCode(), 200);
        assertEquals(actualResponse.getStatusMessage(), "Success");
        assertEquals(actualResponse.getData(), expectedResult);
    }

    @Test
    void testGetPricesForDay14Hour16() throws Exception {
        // Given
        PriceDTO requestBody = new PriceDTO();
        requestBody.setDate("2020-06-14T16:00:00Z");
        requestBody.setProductId(35455);
        requestBody.setBrandId(1);

        PriceResponseDTO expectedResult = PriceResponseDTO.builder().productId(requestBody.getProductId())
                .brandId(requestBody.getBrandId()).price((float) 25.45).startDate("2020-06-14T15:00:00Z")
                .endDate("2020-06-14T18:30:00Z").priceList(2).build();

        // When
        MvcResult result = this.mockMvc.perform(get("/0.0.1/test")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Then
        String stringResponse = result.getResponse().getContentAsString();
        ResponsePrice<PriceResponseDTO> actualResponse = objectMapper.readValue(stringResponse,
                new TypeReference<ResponsePrice<PriceResponseDTO>>() {
                });
        assertEquals(actualResponse.getStatusCode(), 200);
        assertEquals(actualResponse.getStatusMessage(), "Success");
        assertEquals(actualResponse.getData(), expectedResult);
    }

    @Test
    void testGetPricesForDay14Hour21() throws Exception {
        // Given
        PriceDTO requestBody = new PriceDTO();
        requestBody.setDate("2020-06-14T21:00:00Z");
        requestBody.setProductId(35455);
        requestBody.setBrandId(1);

        PriceResponseDTO expectedResult = PriceResponseDTO.builder().productId(requestBody.getProductId())
                .brandId(requestBody.getBrandId()).price((float) 35.50).startDate("2020-06-14T00:00:00Z")
                .endDate("2020-12-31T23:59:59Z").priceList(1).build();

        // When
        MvcResult result = this.mockMvc.perform(get("/0.0.1/test")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Then
        String stringResponse = result.getResponse().getContentAsString();
        ResponsePrice<PriceResponseDTO> actualResponse = objectMapper.readValue(stringResponse,
                new TypeReference<ResponsePrice<PriceResponseDTO>>() {
                });
        assertEquals(actualResponse.getStatusCode(), 200);
        assertEquals(actualResponse.getStatusMessage(), "Success");
        assertEquals(actualResponse.getData(), expectedResult);
    }

    @Test
    void testGetPricesForDay15Hour10() throws Exception {
        // Given
        PriceDTO requestBody = new PriceDTO();
        requestBody.setDate("2020-06-15T10:00:00Z");
        requestBody.setProductId(35455);
        requestBody.setBrandId(1);

        PriceResponseDTO expectedResult = PriceResponseDTO.builder().productId(requestBody.getProductId())
                .brandId(requestBody.getBrandId()).price((float) 30.50).startDate("2020-06-15T00:00:00Z")
                .endDate("2020-06-15T11:00:00Z").priceList(3).build();

        // When
        MvcResult result = this.mockMvc.perform(get("/0.0.1/test")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Then
        String stringResponse = result.getResponse().getContentAsString();
        ResponsePrice<PriceResponseDTO> actualResponse = objectMapper.readValue(stringResponse,
                new TypeReference<ResponsePrice<PriceResponseDTO>>() {
                });
        assertEquals(actualResponse.getStatusCode(), 200);
        assertEquals(actualResponse.getStatusMessage(), "Success");
        assertEquals(actualResponse.getData(), expectedResult);
    }

    @Test
    void testGetPricesForDay16Hour21() throws Exception {
        // Given
        PriceDTO requestBody = new PriceDTO();
        requestBody.setDate("2020-06-16T21:00:00Z");
        requestBody.setProductId(35455);
        requestBody.setBrandId(1);

        PriceResponseDTO expectedResult = PriceResponseDTO.builder().productId(requestBody.getProductId())
                .brandId(requestBody.getBrandId()).price((float) 38.95).startDate("2020-06-15T16:00:00Z")
                .endDate("2020-12-31T23:59:59Z").priceList(4).build();

        // When
        MvcResult result = this.mockMvc.perform(get("/0.0.1/test")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Then
        String stringResponse = result.getResponse().getContentAsString();
        ResponsePrice<PriceResponseDTO> actualResponse = objectMapper.readValue(stringResponse,
                new TypeReference<ResponsePrice<PriceResponseDTO>>() {
                });
        assertEquals(actualResponse.getStatusCode(), 200);
        assertEquals(actualResponse.getStatusMessage(), "Success");
        assertEquals(actualResponse.getData(), expectedResult);
    }

}
