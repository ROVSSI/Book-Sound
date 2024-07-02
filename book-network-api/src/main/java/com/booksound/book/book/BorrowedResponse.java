package com.booksound.book.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class BorrowedResponse {
    private Integer id;
    private String title;
    private String authorName;
    private String isbn;
    private Double rate;
    private Boolean returned;
    private Boolean returnApproved;
}
