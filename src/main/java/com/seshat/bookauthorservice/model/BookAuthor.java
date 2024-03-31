package com.seshat.bookauthorservice.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bookAuthors")
public class BookAuthor {
    @Id
    private String id;
    private String userId;
    private String userName;
    private String authorId;
    private String authorName;
}
