package Services;

import Entities.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryService {

    private List<Book> books = new ArrayList<>();


    // ADD BOOK
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added succesfully!");
    }


    // LIST ALL BOOKS
    public void listBooks() {

        if (books.isEmpty()) {
            System.out.println("⚠ No books registered.");
            return;
        } // IF

        System.out.println("\n=== BOOK LIST ===");

        for (Book book : books) {
            System.out.println(book);
        } // FOR
    } // LIST BOOK


    // FIND BY ISBN
    public Book findByIsbn(String isbn) {

        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            } // IF
        } // FOR
        return null;
    } // BOOK


    // REMOVE BOOK
    public boolean removeBook(String isbn) {

        Book book = findByIsbn(isbn);

        if (book != null) {
            books.remove(book);
            System.out.println("✔ Book removed successfully!");
            return true;
        } // IF

        System.out.println("⚠ Book not found.");
        return false;
    } // REMOVE BOOK


    // SEARCH BY TITLE
    public void searchByTitle(String title) {

        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(book);
                found = true;
            } // IF
        } // FOR

        if (!found) {
            System.out.println("⚠ No books found with this title.");
        } // IF
    } // SEARCH BY TITLE


    // SEARCH BY AUTHOR
    public void searchByAuthor(String author) {

        boolean found = false;

        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                System.out.println(author);
                found = true;
            } // IF
        } // FOR

        if (!found) {
            System.out.println("⚠ No books found for this author.");
        } // IF
    } // SEARCH BY AUTHOR


    // LIST AVAILABLE BOOKS
    public void listAvailableBooks() {

        boolean found = false;

        for (Book book : books) {
            if (book.getQuantity() > 0) {
                System.out.println(book);
                found = true;
            } // IF
        } // FOR

        if (!found) {
            System.out.println("⚠ No available books.");
        } // IF
    } // LIST AVAILABLE BOOKS


    // BORROW BOOK
    public void borrowBook(String isbn) {

        Book book = findByIsbn(isbn);

        if (book == null) {
            System.out.println("⚠ Book not found.");
            return;
        } // BOOK NOT FOUND

        if (book.getQuantity() <= 0) {
            System.out.println("⚠ Book not available.");
            return;
        } // BOOK NOT AVAILABLE


        book.setQuantity(book.getQuantity() - 1);
        System.out.println("✔ Book borrowed successfully!");
    } // BORROW BOOK


    // RETURN BOOK
    public void returnBook(String isbn) {

        Book book = findByIsbn(isbn);

        if (book == null) {
            System.out.println("⚠ Book not found.");
            return;
        }

        book.setQuantity(book.getQuantity() + 1);
        System.out.println("✔ Book returned successfully!");
    } // RETURN BOOK



} // CLASS
