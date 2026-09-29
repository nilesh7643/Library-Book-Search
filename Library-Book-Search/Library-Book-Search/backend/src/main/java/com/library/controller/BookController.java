package com.library.controller;

import com.library.model.Book;
import com.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Book> searchByTitle(
            @PathVariable String title) {

        Book book = bookService.searchByTitle(title);

        return book == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(book);
    }

    @GetMapping("/author/{author}")
    public List<Book> searchByAuthor(
            @PathVariable String author) {

        return bookService.searchByAuthor(author);
    }

    @GetMapping("/category/{category}")
    public List<Book> searchByCategory(
            @PathVariable String category) {

        return bookService.searchByCategory(category);
    }
}
