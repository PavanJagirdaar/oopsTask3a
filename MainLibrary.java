package task3a;

import java.util.Scanner;

class Library {
    private Book[] books;

    // Constructor for Library class
    public Library(int size) {
        books = new Book[size];
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                System.out.println("Book added successfully.");
                return;
            }
        }
        System.out.println("Library is full. Cannot add more books.");
    }

    // Method to remove a book from the library
    public void removeBook(int bookId) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getBookId() == bookId) {
                books[i] = null;
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found in the library.");
    }

    // Method to search for a book by ID
    public void searchBook(int bookId) {
        for (Book book : books) {
            if (book != null && book.getBookId() == bookId) {
                System.out.println("Book found:");
                System.out.println("Book ID: " + book.getBookId());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Available: " + (book.isAvailable() ? "Yes" : "No"));
                return;
            }
        }
        System.out.println("Book not found in the library.");
    }

    // Method to display all books in the library
    public void displayBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            if (book != null) {
                System.out.println("Book ID: " + book.getBookId());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Available: " + (book.isAvailable() ? "Yes" : "No"));
                System.out.println("-------------------------");
            }
        }
    }
}

public class MainLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the library: ");
        int librarySize = scanner.nextInt();
        Library library = new Library(librarySize);

        int choice;

        do {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();

                    Book newBook = new Book(bookId, author, title);
                    library.addBook(newBook);
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeBookId = scanner.nextInt();
                    library.removeBook(removeBookId);
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchBookId = scanner.nextInt();
                    library.searchBook(searchBookId);
                    break;

                case 4:
                    library.displayBooks();
                    break;

                case 0:
                    System.out.println("Exiting the Library System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);

        scanner.close();
    }
}