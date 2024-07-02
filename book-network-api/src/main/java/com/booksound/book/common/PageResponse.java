package com.booksound.book.common;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResponse<T> {
    private List<T> content;
    private int number;
    private int size;
    private Long totalElements;
    private int totalPages;
    private boolean first;
    private boolean last;


}
