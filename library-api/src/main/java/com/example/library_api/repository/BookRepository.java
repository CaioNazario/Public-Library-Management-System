package com.example.library_api.repository;

import com.example.library_api.model.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByIsbn(Long isbn);

    Optional<Book> findByIsbn(Long isbn);

    Optional<Book> findByAuthorContainingIgnoreCase(String author);

    Optional<Book> findByGenreIgnoreCase(String genre);


}
