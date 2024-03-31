package com.seshat.bookauthorservice.repository;

import com.seshat.bookauthorservice.model.BookAuthor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookAuthorRepository extends MongoRepository<BookAuthor, String> {
}
