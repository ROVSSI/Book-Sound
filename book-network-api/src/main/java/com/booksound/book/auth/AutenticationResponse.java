package com.booksound.book.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AutenticationResponse {
    private String token;
}
