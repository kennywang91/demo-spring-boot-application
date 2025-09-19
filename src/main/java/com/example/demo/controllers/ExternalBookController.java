package com.example.demo.controllers;

import com.example.demo.dto.BookDto;
import com.example.demo.services.ExternalBookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExternalBookController {
    private final ExternalBookService externalBookService;

    public ExternalBookController(ExternalBookService externalBookService) {
        this.externalBookService = externalBookService;
    }

    // Example of GET request - https://openlibrary.org/search.json?q=java
    @GetMapping("/searchbooks")
    public List<BookDto> searchBooks(@RequestParam String query) {
        return externalBookService.searchBooks(query);
    }
}
