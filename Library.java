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
        System.out.println( bookId + " | " +  title  + " | " +  author  + " | " + (isIssued ?  "Issued"  :  "Available" ));
    }
}

class Library{
    ArrayList<Book> books = new ArrayList<>();

    void searchAuthor() {
        Scanner scanner = new Scanner (System.in);
        boolean found = false;
        System.out.println("Enter Author to search book : ");
        String author = scanner.nextLine();
        for (Book book : books) {
            if(book.author.equalsIgnoreCase(author)) {
                found = true;
                System.out.println("Book Found : ");
                book.displayBook();
            }
        }
        if (found == false ) {
        System.out.println("No book found!");
    } 
}

    void searchBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title to search book : ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if(book.title.equalsIgnoreCase(title)) {
                System.out.println("BOOK FOUND :");
                book.displayBook();
                return;
            }
        } 
        System.out.println("Book not found!");
    }

    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added Sucessfully!");
  }

  void viewBooks() {
    if(books.isEmpty()) {
        System.out.println("No books found!");
        return;
    }
    for (Book book : books) {
        book.displayBook();
    }
  }

  void issueBook(int bookId) {
    for(Book book : books) {
        if(book.bookId == bookId && !book.isIssued) {
            book.isIssued = true;
            System.out.println("Book issued Sucessfully!");
            return;
        }
    }
  System.out.println("Book is not available.");
}
     void returnBook(int bookId) {
        for (Book book : books) {
            if (book.bookId == bookId && book.isIssued) {
                book.isIssued = false;
                System.out.println("Book returned Sucessfully!");
                return;
            }
        }
        System.out.println("Incorrect Book ID!");
     }
}

class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        while(true) {
        System.out.println("----LIBRARY MANAGEMENT SYSTEM----");
        System.out.println("1. Add Books :");
        System.out.println("2. View Books :");
        System.out.println("3. Issue Book :");
        System.out.println("4. Return Book :");
        System.out.println("5. Search Book by title :");
        System.out.println("6. Search Book by Author :");
        System.out.println("7. Exit ");

        System.out.println("Enter your choice :");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice) {
            case 1 :
                System.out.println("Enter Book ID :");
                int bookId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter title :");
                String title = scanner.nextLine();
                System.out.println("Enter author :");
                String author = scanner.nextLine();
                library.addBook(new Book(bookId,title,author));
                break;

                case 2 :
                    library.viewBooks();
                    break;

                    case 3 :
                        System.out.println("Enter Book ID to issue :");
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
                                    library.searchAuthor();
                                    break;

                                case 7 :
                                    System.out.println("Exiting......");
                                    System.exit(0);
                                    break;

                                default :
                                System.out.println("Invalid Choice try again!");
                                break;
                   
        }

        

        
    } }
}

