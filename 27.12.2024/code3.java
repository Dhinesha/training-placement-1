// Base class representing a Book
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // A book is available by default
    }

    // Method to check out the book
    public void checkout() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully checked out: " + title);
        } else {
            System.out.println("Sorry, " + title + " is currently unavailable.");
        }
    }

    // Method to check in the book
    public void checkin() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("You have successfully checked in: " + title);
        } else {
            System.out.println("The book is already available in the library.");
        }
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Checked Out"));
    }
}

// Derived class for a special type of book (e.g., EBook)
class EBook extends Book {
    private double fileSize; // in MB

    // Constructor
    public EBook(String title, String author, double fileSize) {
        super(title, author); // Call parent constructor
        this.fileSize = fileSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("File Size: " + fileSize + " MB");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        // Create some books
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book2 = new Book("1984", "George Orwell");
        EBook ebook1 = new EBook("The Great Gatsby", "F. Scott Fitzgerald", 1.5);
        
        // Display initial book information
        System.out.println("Library Books:");
        book1.displayDetails();
        book2.displayDetails();
        ebook1.displayDetails();
        
        System.out.println("\nChecking out books...");
        book1.checkout();
        book2.checkout();
        ebook1.checkout();
        
        System.out.println("\nDisplaying updated book information...");
        book1.displayDetails();
        book2.displayDetails();
        ebook1.displayDetails();
        
        System.out.println("\nChecking in books...");
        book1.checkin();
        ebook1.checkin();
        
        System.out.println("\nDisplaying final book information...");
        book1.displayDetails();
        ebook1.displayDetails();
    }
}
