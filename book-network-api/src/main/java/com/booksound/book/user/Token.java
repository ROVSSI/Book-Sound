package com.booksound.book.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String Token;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private LocalDateTime validated;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
