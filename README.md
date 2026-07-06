BookVault

BookVault is a console-based Java application designed to simulate a simple library management system. The project focuses on practicing object-oriented programming, separation of concerns, and basic application structure using services and entities.

---

## Features

- Register books
- Register users
- Borrow books
- Return books
- Track active and returned loans
- List all loans

---

## Project Structure

The project is organized into three main layers:

### Entities

Core domain classes:

- Book
- User
- Loan

### Services

Business logic layer:

- BookService
- UserService
- LoanService

### Menu

Console interface responsible for user interaction and system navigation.

---

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList (in-memory storage)
- Scanner (console input)

---

## How It Works

1. The application starts through the main class.
2. The system loads initial test data.
3. The user interacts through a console menu.
4. Books can be borrowed and returned.
5. Loans are tracked with status and dates.

---

## How to Run

1. Open the project in IntelliJ IDEA or another Java IDE.
2. Ensure JDK is properly configured.
3. Run the `Program` class inside the `Application` package.
4. Use the console menu to interact with the system.

---

## What I Practiced

- Object-oriented design
- Separation of responsibilities between layers
- Basic system architecture
- State management (loans and inventory)
- Console-based user interaction

---

## Possible Improvements

- Add database persistence (MySQL or PostgreSQL)
- Replace title-based search with unique IDs
- Improve input validation and error handling
- Refactor into a REST API using Spring Boot

---

## Author

Developed by **Gabarchive** as a Java study project focused on OOP and system design fundamentals.
