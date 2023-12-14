package com.qindel.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qindel.test.dto.factory.PriceBaseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO extends PriceBaseDTO {

    @JsonProperty("date")
    private String date;

}
