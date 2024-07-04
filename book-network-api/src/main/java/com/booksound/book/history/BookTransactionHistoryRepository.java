package com.booksound.book.history;


import com.booksound.book.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookTransactionHistoryRepository extends JpaRepository<BookTransactionHistory, Integer> {
    @Query("""
            SELECT history
            FROM BookTransactionHistory history
            WHERE history.user.id = :userId
            """)
    Page<BookTransactionHistory> findAllBorrowedBooks(Pageable pageable, Integer userId);

    @Query("""
            SELECT history
            FROM BookTransactionHistory history
            WHERE history.book.owner.id = :userId
            """)
    Page<BookTransactionHistory> findAllReturnedBooks(Pageable pageable, Integer userId);

    @Query("""
    SELECT (count (*) > 0) AS isBorrowed
    FROM BookTransactionHistory bookTransationHistory
    WHERE bookTransationHistory.user.id = :userId
    AND bookTransationHistory.book.id = :bookId
    AND bookTransationHistory.returnApproved = false
""")
    boolean isAlreadyBorrowed(Book bookId, Integer userId);

    @Query("""
    SELECT transaction
    FROM BookTransactionHistory transaction
    WHERE transaction.user.id = :userId
    AND transaction.book.id = :bookId
    AND transaction.returnApproved = false
    AND transaction.returned = false
""")
    Optional<BookTransactionHistory> findByBookIdAndUserId(Integer bookId, Integer userId);

    @Query("""
    SELECT transaction
    FROM BookTransactionHistory transaction
    WHERE transaction.book.owner.id = :userId
    AND transaction.book.id = :bookId
    AND transaction.returnApproved = true
    AND transaction.returned = false
""")
    Optional<BookTransactionHistory> findByBookIdAndOwnerId(Integer bookId, Integer userId);
}
