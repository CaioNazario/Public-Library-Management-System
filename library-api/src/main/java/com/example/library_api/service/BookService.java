package com.example.library_api.service;

import com.example.library_api.DTO.BookRequest;
import com.example.library_api.DTO.BookResponse;
import com.example.library_api.model.Book;
import com.example.library_api.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public BookResponse createBook(BookRequest request) {

        if (bookRepository.existsById((long) request.id())) {
            throw new IllegalArgumentException("Id já existente");
        }

        if (bookRepository.existsByIsbn(request.isbn())) {
            throw new IllegalArgumentException("ISBN já existe");
        }

        int currentYear = Year.now().getValue();
        if (request.year() > currentYear) {
            throw new IllegalArgumentException("Publication year cannot be in the future");
        }

        if (request.available() <= 0) {
            throw new IllegalArgumentException("Book quantity must be greater than 0");
        }

        Book book = new Book();
        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setIsbn(request.isbn());
        book.setPublisher(request.publisher());
        book.setYear(request.year());
        book.setGenre(request.genre());
        book.setLanguage(request.language());
        book.setPages(request.pages());

        Book saved = bookRepository.save(book);


        return new BookResponse(
                saved.getTitle(),
                saved.getAuthor(),
                saved.getPublisher(),
                saved.getYear(),
                saved.getGenre(),
                saved.getAvailable(),
                saved.getPages(),
                saved.getLanguage()
        );
    }


    public List<BookResponse> listAll() {
        return bookRepository.findAll().stream()
                .map(book -> new BookResponse(
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPublisher(),
                        book.getYear(),
                        book.getGenre(),
                        book.getAvailable(),
                        book.getPages(),
                        book.getLanguage()
                ))
                .toList();
    }


    public BookResponse getById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + id));

        return new BookResponse(
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getYear(),
                book.getGenre(),
                book.getAvailable(),
                book.getPages(),
                book.getLanguage()
        );
    }


    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Book not found with ID: " + id);
        }
        bookRepository.deleteById(id);
    }
}
