package Services;

import Entities.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * Service responsible for managing books.
 */
public class BookService {

    private List<Book> books = new ArrayList<>();

    // Adds a new book to the system
    public void addBook(Book book) {
        books.add(book);
    }

    // Finds a book by its title
    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}