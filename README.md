# Library Management System (Java)

A simple **console-based Library Management System** in Java.  
This project demonstrates **object-oriented programming (OOP) concepts** for beginners, including classes, objects, ArrayLists, and methods.

---

## Features

- Add books to the library
- View all books in the library
- Issue a book (mark it as issued)
- Return a book (mark it as available)
- User-friendly console menu
- Search Book

---

## Classes

### Book
Represents a single book with the following properties:

- `bookId` (int)
- `title` (String)
- `author` (String)
- `isIssued` (boolean, default `false`)

Methods:

- `displayBook()` – prints book details and its issued status

### Library
Manages a collection of `Book` objects.

Methods:

- `addBook(Book book)` – adds a new book to the library
- `viewBooks()` – lists all books in the library
- `issueBook(int bookId)` – issues a book if available
- `returnBook(int bookId)` – returns a book if it was issued

---

## How to Run

1. Clone or download the repository.
2. Compile all `.java` files:
```bash
javac Main.java
