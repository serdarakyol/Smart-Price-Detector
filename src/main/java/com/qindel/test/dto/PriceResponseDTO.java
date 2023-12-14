package com.qindel.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.qindel.test.dto.factory.PriceBaseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PriceResponseDTO extends PriceBaseDTO {

    @JsonProperty("price_list")
    @SerializedName("price_list")
    private Integer priceList;

    @JsonProperty("start_date")
    @SerializedName("start_date")
    private String startDate;

    @JsonProperty("end_date")
    @SerializedName("end_date")
    private String endDate;

    @JsonProperty("price")
    @SerializedName("price")
    private Float price;

}
