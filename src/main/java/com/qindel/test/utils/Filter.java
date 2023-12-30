package com.qindel.test.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.Getter;

@Getter
public class Filter {

    private Pageable pageable;
    private Integer limit;
    private Integer offset;

    public Filter(Integer limit, Integer offset) {
        this.loadLimitAndOffset(limit, offset);
        this.loadPage();
    }

    private void loadPage() {
        Sort sort = Sort.by("priority").descending();
        if (this.offset != null && this.limit != null) {
            this.pageable = PageRequest.of(this.offset, this.limit, sort);
        } else if (this.offset != null && this.limit == null) {
            this.pageable = PageRequest.of(this.offset, 100, sort);
        } else if (this.offset == null && this.limit != null) {
            this.pageable = PageRequest.of(0, this.limit, sort);
        } else {
            this.pageable = PageRequest.of(0, 100, sort);
        }
    }

    private void loadLimitAndOffset(Integer limit, Integer offset) {
        this.limit = limit;
        this.offset = offset;
    }

}
