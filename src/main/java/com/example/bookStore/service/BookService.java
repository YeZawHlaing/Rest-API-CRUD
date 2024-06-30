package com.example.bookStore.service;

import com.example.bookStore.model.Book;

import java.util.List;

public interface BookService {

    Book createBooks(Book books);
    List<Book> getAllBooks();
    Book updateBooks(Book book, Long id);
    Book deleteBooks(Long id);
}
