package com.example.bookStore.controller;


import com.example.bookStore.model.Book;
import com.example.bookStore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Book/")
@RequiredArgsConstructor
public class BookController {

   @Autowired
    private BookService bookService;



    @PostMapping("/upload")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.createBooks(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/getBook")
    public List<Book> getAllbook(){
        return bookService.getAllBooks();
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestParam (name = "id") long id, @RequestBody Book book){
        Book updateBook=bookService.updateBooks(book,id);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<Book> deleteBook(@RequestParam (name = "id") long id){
        Book deleteBook=bookService.deleteBooks(id);
        return new ResponseEntity<>(deleteBook,HttpStatus.OK);
    }



}
