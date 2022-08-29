package com.savvycom.studentmanagement.domain.dto;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageDto<T extends Serializable> implements Serializable {

    private int code;

    private String message;

    private long limit;

    private long offset;

    private long total;

    private List<?> results;

    public PageDto(Page page, List<T> data, int code, String message) {
        this.results = data;
        this.code = code;
        this.message = message;
        this.limit = page.getSize();
        this.total = page.getNumberOfElements();
        this.offset = page.getNumber() + 1L;
    }

    public PageDto(Page page, List<T> data, int code, String message, boolean offset) {
        this.results = data;
        this.code = code;
        this.message = message;
        this.limit = page.getSize();
        this.total = page.getNumberOfElements();
        this.offset = page.getNumber();
    }

    public PageDto(int limit, int offset, Long total, List<T> data, int code, String message) {
        this.results = data;
        this.code = code;
        this.message = message;
        this.limit = limit;
        this.total = total;
        this.offset = offset;
    }
}
