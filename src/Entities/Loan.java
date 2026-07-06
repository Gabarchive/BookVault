package Entities;

import java.time.LocalDate;

/**
 * Represents a book loan in the system.
 */
public class Loan {

    private Book book;
    private User user;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(Book book, User user) {
        this.book = book;
        this.user = user;
        this.loanDate = LocalDate.now();
        this.returnDate = null;
    }

    // Marks the book as returned
    public void returnBook() {
        this.returnDate = LocalDate.now();
    }

    // Checks if the loan is already returned
    public boolean isReturned() {
        return returnDate != null;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    // CLEAN PRESENTATION (IMPORTANT)
    public void printLoan() {
        System.out.println("\n📖 LOAN INFO");
        System.out.println("Book  : " + book.getTitle());
        System.out.println("User  : " + user.getName());
        System.out.println("Date  : " + loanDate);
        System.out.println("Status: " + (isReturned() ? "RETURNED" : "ACTIVE"));
        System.out.println("----------------------------");
    }
}