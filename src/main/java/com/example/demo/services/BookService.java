package com.example.demo.services;

import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Page<Book> getBooks(int page, int size) {
        return bookRepository.findAll(PageRequest.of(page, size));
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        // Update fields
        book.setName(bookDetails.getName());
        book.setAuthor(bookDetails.getAuthor());
        book.setQuantity(bookDetails.getQuantity());

        return bookRepository.save(book);
    }
}
