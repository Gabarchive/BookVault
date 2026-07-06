package Menu;

import Services.BookService;
import Services.UserService;
import Services.LoanService;
import Entities.Book;
import Entities.User;
import Entities.Loan;

import java.util.Scanner;

/**
 * Main menu of the BookVault system.
 */
public class Menu {

    private BookService bookService = new BookService();
    private UserService userService = new UserService();
    private LoanService loanService = new LoanService();

    public void start() {

        Scanner sc = new Scanner(System.in);
        int option;

        // Initial test data (FIXED for 5-parameter Book constructor)
        bookService.addBook(new Book(
                "Java Basics",
                "Author A",
                "ISBN-001",
                2024,
                2
        ));

        userService.addUser(new User("Gabriel"));

        do {
            System.out.println("\n===== BOOKVAULT SYSTEM =====");
            System.out.println("1 - Borrow Book");
            System.out.println("2 - Return Book");
            System.out.println("3 - List Loans");
            System.out.println("0 - Exit");
            System.out.print("Choose an option: ");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1 -> {
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter user name: ");
                    String name = sc.nextLine();

                    Book book = bookService.findByTitle(title);
                    User user = userService.findByName(name);

                    if (book == null || user == null) {
                        System.out.println("⚠ Book or User not found.");
                        break;
                    }

                    loanService.borrowBook(book, user);
                }

                case 2 -> {
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();

                    Book book = bookService.findByTitle(title);

                    if (book == null) {
                        System.out.println("⚠ Book not found.");
                        break;
                    }

                    Loan loan = loanService.findActiveLoanByBook(book);

                    if (loan == null) {
                        System.out.println("⚠ Active loan not found.");
                        break;
                    }

                    loanService.returnBook(loan, book);
                }

                case 3 -> loanService.listLoans();

                case 0 -> System.out.println("Exiting system...");

                default -> System.out.println("Invalid option.");
            }

        } while (option != 0);
    }
}