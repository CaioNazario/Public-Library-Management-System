package com.example.library_api.DTO;


public record BookRequest(

        int id,
        String title,
        String author,
        String publisher,
        int year,
        String genre,
        int available,
        int pages,
        String language,
        Long isbn

) {

}
