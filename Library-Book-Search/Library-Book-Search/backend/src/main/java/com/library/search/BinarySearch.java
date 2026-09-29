package com.library.search;

import com.library.model.Book;
import java.util.List;

public final class BinarySearch {

    private BinarySearch() {}

    public static Book searchByTitle(List<Book> books, String target) {
        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String current = books.get(mid).getTitle();

            int comparison = current.compareToIgnoreCase(target);

            if (comparison == 0) {
                return books.get(mid);
            }

            if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
}
