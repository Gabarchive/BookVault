package Services;

import Entities.Book;
import Entities.Loan;
import Entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Service responsible for managing loans.
 */
public class LoanService {

    private List<Loan> loans = new ArrayList<>();

    // Creates a new book loan
    public void borrowBook(Book book, User user) {

        if (book.getQuantity() <= 0) {
            System.out.println("⚠ Book not available.");
            return;
        }

        book.setQuantity(book.getQuantity() - 1);

        Loan loan = new Loan(book, user);
        loans.add(loan);

        System.out.println("✔ Loan created successfully!");
    }

    // Returns a borrowed book
    public void returnBook(Loan loan, Book book) {

        if (loan.isReturned()) {
            System.out.println("⚠ Book already returned.");
            return;
        }

        loan.returnBook();
        book.setQuantity(book.getQuantity() + 1);

        System.out.println("✔ Book returned successfully!");
    }

    // Lists all loans
    public void listLoans() {

        if (loans.isEmpty()) {
            System.out.println("⚠ No loans found.");
            return;
        }

        System.out.println("\n===== LOANS LIST =====");

        for (Loan loan : loans) {
            loan.printLoan();
        }
    }

    // Finds an active loan by book
    public Loan findActiveLoanByBook(Book book) {

        for (Loan loan : loans) {
            if (loan.getBook().equals(book) && !loan.isReturned()) {
                return loan;
            }
        }

        return null;
    }
}