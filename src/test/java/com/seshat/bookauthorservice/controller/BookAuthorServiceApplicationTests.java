package com.seshat.bookauthorservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seshat.bookauthorservice.model.BookAuthor;
import com.seshat.bookauthorservice.service.BookAuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookAuthorController.class)
    public class BookAuthorServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookAuthorService bookAuthorService;

    @Test
    public void testAddBookAuthor() throws Exception {
        // Prepare sample data
        BookAuthor bookAuthorToAdd = new BookAuthor("1", "S001", "John Doe", "A001", "Dr. Seuss");
        BookAuthor addedBookAuthor = new BookAuthor("1", "S001", "John Doe", "A001", "Dr. Seuss");

        // Mock the service method to return the added book author
        when(bookAuthorService.addBookAuthor(any(BookAuthor.class))).thenReturn(addedBookAuthor);

        // Perform the POST request with the book author data
        mockMvc.perform(post("/bookAuthors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(bookAuthorToAdd)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("1")) // Check if the returned book author ID matches
                .andExpect(jsonPath("$.userId").value("S001")) // Check if the returned user ID matches
                .andExpect(jsonPath("$.userName").value("John Doe")) // Check if the returned user name matches
                .andExpect(jsonPath("$.authorId").value("A001")) // Check if the returned author ID matches
                .andExpect(jsonPath("$.authorName").value("Dr. Seuss")); // Check if the returned author name matches
    }

    // Helper method to convert object to JSON string
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}