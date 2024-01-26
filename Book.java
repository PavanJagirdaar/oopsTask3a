package task3a;

class Book {
    private int bookId;
    private String author;
    private String title;
    private boolean isAvailable;

    // Constructor for Book class
    public Book(int bookId, String author, String title) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.isAvailable = true;
    }

    // Getter for bookId
    public int getBookId() {
        return bookId;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for isAvailable
    public boolean isAvailable() {
        return isAvailable;
    }

    // Method to mark the book as unavailable
    public void checkout() {
        isAvailable = false;
    }

    // Method to mark the book as available
    public void returnBook() {
        isAvailable = true;
    }
}
