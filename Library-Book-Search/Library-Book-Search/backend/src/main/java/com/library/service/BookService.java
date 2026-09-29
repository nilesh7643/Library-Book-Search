package com.library.service;

import com.library.model.Book;
import com.library.search.BinarySearch;
import com.library.search.HashMapSearch;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();
    private final HashMapSearch hashMapSearch = new HashMapSearch();

    public BookService() {
        books.add(new Book(1L, "Clean Code", "Robert C. Martin",
                "Programming", "9780132350884", true));

        books.add(new Book(2L, "Java Complete Reference", "Herbert Schildt",
                "Programming", "9781260440232", true));

        books.add(new Book(3L, "The Alchemist", "Paulo Coelho",
                "Fiction", "9780062315007", false));

        books.add(new Book(4L, "Atomic Habits", "James Clear",
                "Self Help", "9780735211292", true));

        books.add(new Book(5L, "Introduction to Algorithms",
                "Thomas H. Cormen", "Computer Science",
                "9780262046305", true));

        books.add(new Book(6L, "Python Crash Course", "Eric Matthes",
                "Programming", "9781718502703", true));

        books.add(new Book(7L, "The Pragmatic Programmer",
                "Andrew Hunt", "Programming",
                "9780135957059", false));

        books.sort(Comparator.comparing(
                Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        hashMapSearch.buildIndexes(books);
    }

    public List<Book> getAllBooks() {
        return Collections.unmodifiableList(books);
    }

    public Book searchByTitle(String title) {
        return BinarySearch.searchByTitle(books, title);
    }

    public List<Book> searchByAuthor(String author) {
        return hashMapSearch.searchByAuthor(author);
    }

    public List<Book> searchByCategory(String category) {
        return hashMapSearch.searchByCategory(category);
    }
}
