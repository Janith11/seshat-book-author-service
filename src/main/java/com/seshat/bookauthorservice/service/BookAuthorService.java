package com.seshat.bookauthorservice.service;

import com.seshat.bookauthorservice.model.BookAuthor;

import java.util.List;
import java.util.Optional;

public interface BookAuthorService {
    List<BookAuthor> getAllBookAuthors();

    Optional<BookAuthor> getBookAuthorById(String id);

    BookAuthor addBookAuthor(BookAuthor bookAuthor);

    BookAuthor updateBookAuthor(String id, BookAuthor bookAuthor);

    void deleteBookAuthor(String id);
}
