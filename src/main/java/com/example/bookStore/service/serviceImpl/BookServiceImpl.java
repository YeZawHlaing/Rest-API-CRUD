package com.example.bookStore.service.serviceImpl;

import com.example.bookStore.model.Book;
import com.example.bookStore.repository.BookRepository;
import com.example.bookStore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepository bookRepository;



    @Override
    public Book createBooks(Book books) {
      return bookRepository.save(books);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBooks(Book book, Long id) {
        Book is_exist=bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        is_exist.setTitle(book.getTitle());
        is_exist.setPrice(book.getPrice());
        bookRepository.save(is_exist);

        return is_exist;
    }

    @Override
    public Book deleteBooks(Long id) {
        Book is_exist=bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        bookRepository.deleteById(id);
        return is_exist;
    }
}
