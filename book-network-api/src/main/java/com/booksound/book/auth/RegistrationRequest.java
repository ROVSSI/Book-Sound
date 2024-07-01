package com.booksound.book.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "FirstName is Mandatory")
    @NotBlank(message = "FirstName is Mandatory")
    private String firstName;
    @NotEmpty(message = "LastName is Mandatory")
    @NotBlank(message = "LastName is Mandatory")
    private String lastName;
    @Email(message = "Email is not formatted")
    @NotEmpty(message = "Email is Mandatory")
    @NotBlank(message = "Email is Mandatory")
    private String email;
    @NotEmpty(message = "Password is Mandatory")
    @NotBlank(message = "Password is Mandatory")
    @Size(min = 8, message = "Password should be 8 characters minimum")
    private String password;

}
