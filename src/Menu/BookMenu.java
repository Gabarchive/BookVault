package Menu;

import Entities.Book;
import Services.LibraryService;

import java.util.Scanner;

public class BookMenu {

    private LibraryService libraryService = new LibraryService();

    public void showMenu(Scanner sc) {

        int option = 0;

        while (option != 8) {

            System.out.println("\n========== BOOK MENU ==========");
            System.out.println("1 - Add Book");
            System.out.println("2 - List Books");
            System.out.println("3 - Remove Book");
            System.out.println("4 - Search by Title");
            System.out.println("5 - Search by Author");
            System.out.println("6 - Borrow Book");
            System.out.println("7 - Return Book");
            System.out.println("8 - Back");
            System.out.print("Choose: ");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:
                    addBook(sc);
                    break;

                case 2:
                    libraryService.listBooks();
                    break;

                case 3:
                    removeBook(sc);
                    break;

                case 4:
                    searchByTitle(sc);
                    break;

                case 5:
                    searchByAuthor(sc);
                    break;

                case 6:
                    borrowBook(sc);
                    break;

                case 7:
                    returnBook(sc);
                    break;

                case 8:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }



    // METHODS MISSING
    private void addBook(Scanner sc){

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Year: ");
        int year = sc.nextInt();

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        Book book = new Book(title, author, isbn, year, quantity);
        libraryService.addBook(book);
    } // ADD BOOKS IN LIBRARY SERVICE



    // REMOVE BOOKS
    private void removeBook(Scanner sc){

        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        libraryService.removeBook(isbn);
    } // REMOVE BOOK



    // SEARCH BY TITLE
    private void searchByTitle(Scanner sc){

        System.out.print("Title: ");
        String title = sc.nextLine();

        libraryService.searchByTitle(title);
    } // SEARCH BY TITLE



    // SEARCH BY AUTHOR
    private void searchByAuthor(Scanner sc){

        System.out.print("Author : ");
        String author = sc.nextLine();

        libraryService.searchByAuthor(author);
    } // SEARCH BY AUTHOR



    // BORROW BOOK
    private void borrowBook(Scanner sc){

        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        libraryService.borrowBook(isbn);
    } // BORROW BOOK



    // RETURN BOOK
    private void returnBook(Scanner sc){

        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        libraryService.returnBook(isbn);
    } // RETURN BOOK
}