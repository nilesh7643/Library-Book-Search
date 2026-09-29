package com.library.search;

import com.library.model.Book;
import java.util.*;

public class HashMapSearch {

    private final Map<String, List<Book>> authorIndex = new HashMap<>();
    private final Map<String, List<Book>> categoryIndex = new HashMap<>();

    public void buildIndexes(List<Book> books) {
        authorIndex.clear();
        categoryIndex.clear();

        for (Book book : books) {
            authorIndex
                .computeIfAbsent(normalize(book.getAuthor()),
                    key -> new ArrayList<>())
                .add(book);

            categoryIndex
                .computeIfAbsent(normalize(book.getCategory()),
                    key -> new ArrayList<>())
                .add(book);
        }
    }

    public List<Book> searchByAuthor(String author) {
        return authorIndex.getOrDefault(
            normalize(author), Collections.emptyList());
    }

    public List<Book> searchByCategory(String category) {
        return categoryIndex.getOrDefault(
            normalize(category), Collections.emptyList());
    }

    private String normalize(String value) {
        return value.trim().toLowerCase();
    }
}
