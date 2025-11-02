package com.example.library_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "titulo", nullable = false, unique = true)
    private String title;
    @Column(name = "autor", nullable = false)
    private String author;
    @Column(name = "isbn", nullable = false, unique = true)
    private Long isbn;
    @Column(name = "editora", nullable = false)
    private String publisher;
    @Column(name = "ano", nullable = false)
    private int year;
    @Column(name = "genero", nullable = false)
    private String genre;
    @Column(name = "quantidade", nullable = false)
    private int available;
    @Column(name = "paginas", nullable = false)
    private int pages;
    @Column(name = "idioma", nullable = false)
    private String language;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Long getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getAvailable() {
        return available;
    }

    public int getPages() {
        return pages;
    }

    public String getLanguage() {
        return language;
    }
}
