package com.bootstrap.simple.application.app.controller;

import com.bootstrap.simple.application.app.BookNotFoundExeption;
import com.bootstrap.simple.application.app.BookRepository;
import com.bootstrap.simple.application.app.persistence.model.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author leo
 */
@RestController
@RequestMapping(BookController.API_BOOKS)
public class BookController {

    public static final String API_BOOKS = "/api/books";
    public static final String ID = "/{id}";
    public static final String TITLE_BOOK_TITLE = "/title/{bookTitle}";

    @Autowired
    private BookRepository repository;

    @GetMapping
    public Iterable findAll() {
        return this.repository.findAll();
    }

    @GetMapping(TITLE_BOOK_TITLE)
    public List findByTitle(@PathVariable String title) {
        return this.repository.findByTitle(title);
    }

    @GetMapping(ID)
    public Book findOne(@PathVariable Long id) {
        return this.repository.findById(id).orElseThrow(BookNotFoundExeption::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return this.repository.save(book);
    }

    @DeleteMapping(ID)
    public void delete(@PathVariable Long id) {
        this.repository.findById(id).orElseThrow(BookNotFoundExeption::new);
        this.repository.deleteById(id);
    }

    @PutMapping(ID)
    public Book updated(@PathVariable Long id, @RequestBody Book book) {
        if (book.getId() != id) {
            throw new BookIdMismatchException();
        }
        this.repository.findById(id)
                .orElseThrow(BookNotFoundExeption::new);
        return this.repository.save(book);
    }

}
