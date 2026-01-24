import java.util.Scanner;
import java.util.ArrayList;

class Book{
    int bookId;
    String title;
    String author;
    boolean isIssued;

    Book(int bookId,String title,String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void displayBook() {
        System.out.println(bookId + "| " + title + "| " + author + "| " + (isIssued ? "Issued" : "Available"));
    }

}

class Library{
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added Successfully!");
    }

    void viewBook() {
        if(books.isEmpty()) {
            System.out.println("Books not found!");
            return;
        }
        for(Book book : books) {
           book.displayBook();
        }
    }

    void issueBook(int bookId) {
        for(Book book : books) {
        if(book.bookId == bookId && !book.isIssued) {
           book.isIssued = true;
            System.out.println("Book Issued Successfully!");
            return;
        }
    } 
    System.out.println("Book is not Available!");
}

void viewIssuedBook() {
    boolean issuedFound = false;
    for(Book book : books) {
        if(book.isIssued) {
            issuedFound = true;
            book.displayBook();
        }
    }
    if(issuedFound == false) {
    System.out.println("No books were issued!");
    }
}

void viewAvailableBook() {
    boolean availableFound = false;
    for(Book book : books) {
        if(!book.isIssued) {
            availableFound = true;
            book.displayBook();
        }
    }
    if(availableFound == false) {
        System.out.println("No Books are Available.");
    }
}
   void returnBook(int bookId) {
    for(Book book : books) {
        if(book.bookId == bookId && book.isIssued) {
            book.isIssued = false;
            System.out.println("Book returned Successfully!");
            return;
        }
    }
    System.out.println("Invalid Book ID!");
   }

   void searchBook() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Book title to Search : ");
    String title = scanner.nextLine();
    for (Book book : books) {
        if(book.title.equalsIgnoreCase(title)) {
            System.out.println("Book Found!");
            book.displayBook();
            return;
        }
    }
    System.out.println("Book not found!");
   }
 }

 class Main{
    public static void main(String[] args) {
        
    
    Scanner scanner = new Scanner(System.in);
    Library library = new Library();
    while(true) {
    System.out.println("----LIBRARY MANAGEMENT SYSTEM----");
    System.out.println("1. Add Book :");
    System.out.println("2. View Book :");
    System.out.println("3. Issue Book :");
    System.out.println("4. Return Book :");
    System.out.println("5. Search Book :");
    System.out.println("6. View Issued Books :");
    System.out.println("7. View Available Books :");
    System.out.println("8. Exit : ");
    System.out.println("Enter your choice : ");
    int choice = scanner.nextInt();
    scanner.nextLine();

    switch(choice) {
        case 1 :
            System.out.println("Enter Book ID : ");
            int bookId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Book title :");
            String title = scanner.nextLine();
            System.out.println("Enter Book author :");
            String author = scanner.nextLine();
            library.addBook(new Book(bookId,title,author));
            System.out.println("Book added Successfully!");
            break;

            case 2 :
                library.viewBook();
                break;

                case 3 :
                    System.out.println("Enter Book ID to issue:");
                    library.issueBook(scanner.nextInt());
                    break;

                    case 4 :
                        System.out.println("Enter Book ID to return :");
                        library.returnBook(scanner.nextInt());
                        break;

                        case 5 :
                            library.searchBook();
                            break;

                            case 6 :
                                library.viewIssuedBook();
                                break;

                                case 7 :
                                    library.viewAvailableBook();
                                    break;

                            case 8 :
                                System.out.println("Exiting............");
                                System.exit(0);
                                break;

                                default :
                                System.out.println("Invalid choice!Try again");
                                break;
    }

 }
 } }
