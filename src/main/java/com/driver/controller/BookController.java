package com.driver.controller;

import com.driver.models.Book;
import com.driver.repositories.BookRepository;
import com.driver.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

//Add required annotations

@RestController
@EnableSwagger2
public class BookController {


    //Write createBook API with required annotations

    @Autowired
    BookService bookService;
    //Add required annotations
    @GetMapping("/book")
    public ResponseEntity getBooks(@RequestParam(value = "genre", required = false) String genre,
                                   @RequestParam(value = "available", required = false, defaultValue = "false") boolean available,
                                   @RequestParam(value = "author", required = false) String author){

        List<Book> bookList = bookService.getBooks(genre,available,author);

        return new ResponseEntity<>(bookList, HttpStatus.OK);

    }

    @PostMapping("/book")
    public ResponseEntity createBook(@RequestBody Book book){
        bookService.createBook(book);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }
}