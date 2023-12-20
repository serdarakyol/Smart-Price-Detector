package com.qindel.test.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qindel.test.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {

    /**
     * @param productId:    Product ID
     * @param brandId:      Brand ID
     * @param startDateRoi: Discount start date
     * @param endDateRoi:   Discount stop date
     * @return Get all prices with product ID, Brand ID and date between start and
     *         end
     */
    List<Price> findByProductIdAndBrand_IdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Integer productId,
            Integer brandId, Instant startDateRoi, Instant endDateRoi, Pageable pageable);

}
