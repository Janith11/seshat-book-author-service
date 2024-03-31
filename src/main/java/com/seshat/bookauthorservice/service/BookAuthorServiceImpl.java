package com.seshat.bookauthorservice.service;
import com.seshat.bookauthorservice.model.BookAuthor;
import com.seshat.bookauthorservice.repository.BookAuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookAuthorServiceImpl implements BookAuthorService {

    private final BookAuthorRepository bookAuthorRepository;

    @Override
    public List<BookAuthor> getAllBookAuthors() {
        return this.bookAuthorRepository.findAll();
    }

    @Override
    public Optional<BookAuthor> getBookAuthorById(String id) {
        return this.bookAuthorRepository.findById(id);
    }

    @Override
    public BookAuthor addBookAuthor(BookAuthor page) {
        return this.bookAuthorRepository.save(page);
    }

    @Override
    public BookAuthor updateBookAuthor(String id, BookAuthor page) {
        if (this.bookAuthorRepository.existsById(id)) {
            page.setId(id);
            return this.bookAuthorRepository.save(page);
        } else {
            return null; // or throw exception
        }
    }

    @Override
    public void deleteBookAuthor(String id) {
        this.bookAuthorRepository.deleteById(id);
    }
}