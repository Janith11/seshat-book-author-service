package com.seshat.bookauthorservice.controller;

import com.seshat.bookauthorservice.model.BookAuthor;
import com.seshat.bookauthorservice.service.BookAuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookAuthor")
public class BookAuthorController {

    private final BookAuthorService bookAuthorService;

    @GetMapping
    public ResponseEntity<List<BookAuthor>> getAllBookAuthors() {
        List<BookAuthor> bookAuthors = this.bookAuthorService.getAllBookAuthors();
        return new ResponseEntity<>(bookAuthors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookAuthor> getBookAuthorById(@PathVariable String id) {
        Optional<BookAuthor> bookAuthor = this.bookAuthorService.getBookAuthorById(id);
        return bookAuthor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<BookAuthor> addBookAuthor(@RequestBody BookAuthor bookAuthor) {
        BookAuthor newbookAuthor = this.bookAuthorService.addBookAuthor(bookAuthor);
        return new ResponseEntity<>(newbookAuthor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookAuthor> updateBookAuthor(@PathVariable String id, @RequestBody BookAuthor bookAuthor) {
        BookAuthor updateBookAuthor = this.bookAuthorService.updateBookAuthor(id, bookAuthor);
        if (updateBookAuthor != null) {
            return new ResponseEntity<>(updateBookAuthor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookAuthor(@PathVariable String id) {
        this.bookAuthorService.deleteBookAuthor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
