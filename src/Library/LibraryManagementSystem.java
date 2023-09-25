package Library;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int bookId;
    private boolean isAvailable;

    public Book(String title, String author, int bookId) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " (ID: " + book.getBookId() + ")");
        }
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(int bookId) {
        Book book = findBookById(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("You have borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Sorry, the book is not available for borrowing.");
        }
    }

    public void returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("You have returned the book: " + book.getTitle());
        } else {
            System.out.println("Invalid book ID or the book is already available.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("Rich Dad Poor Dad", "Robert Kiyosaki", 101));
        library.addBook(new Book("Sri Rama Darshana", "kuvempu", 102));
        library.addBook(new Book("Wings of Fire", "A.P.J Abdual Kalam and Arun Tiwari", 103));

        int choice;
        do {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Display all books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the book ID to borrow: ");
                    int borrowBookId = scanner.nextInt();
                    scanner.nextLine();
                    library.borrowBook(borrowBookId);
                    break;
                case 3:
                    System.out.print("Enter the book ID to return: ");
                    int returnBookId = scanner.nextInt();
                    scanner.nextLine();
                    library.returnBook(returnBookId);
                    break;
                case 4:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

