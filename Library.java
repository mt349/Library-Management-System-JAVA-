import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Book{
    int bookId;
    String title;
    String author;
    boolean isIssued;

    Book(int bookId, String title , String author ) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void displayBook() {
        System.out.println(bookId + " | " + title + " | " + author + " | " + (isIssued ? "Issued" : "Available"));
    }
}

class Library{
    ArrayList<Book> books = new ArrayList<>();
    String fileName = "books.txt" ;

    //Constructer
    Library() {
        loadFromFile();
    }

    void saveToFile() {
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter (fileName));

        for(Book book : books) {
            bw.write(book.bookId+"," +book.title+","+book.author+","+book.isIssued);
            bw.newLine();
        }
        bw.close();
    } catch (IOException e) {
        System.out.println("Error saving data.");
    }
}
void loadFromFile() {
    try {
        File file = new File(fileName);
        if(!file.exists()) return;

        Scanner fileScanner = new Scanner (file);

        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] data = line.split(",");

            int id = Integer.parseInt(data[0]);
            String title = data[1];
            String author = data[2];
            boolean isIssued = Boolean.parseBoolean(data[3]);

            Book book = new Book(id,title,author);
            book.isIssued = isIssued;
            books.add(book);
        }
        fileScanner.close();
    } catch (Exception e ) {
        System.out.println("Error loading data.");
    }
}
    void addBook(Book book) {
        books.add(book);
        saveToFile();
        System.out.println("Book Added Successfully!");
    }

    void viewBook() {
        if(books.isEmpty()) {
            System.out.println("No Book found!");
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
                saveToFile();
                System.out.println("Book Issued Successfully!");
                return;
            }
        }
        System.out.println("Book is not Available.");
    }
    void returnBook(int bookId) {
        for(Book book : books) {
            if(book.bookId == bookId && book.isIssued) {
                book.isIssued = false;
                saveToFile();
                System.out.println("Book returned Successfully!");
                return;
            }
        }
        System.out.println("INVALID BOOK ID! TRY AGAIN");
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
        System.out.println("No Books are Issued.");
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
        System.out.println("No Books are Available!");
    }
    }
    void searchBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Title of the Book to Search :");
        String title = scanner.nextLine();
        for(Book book : books) {
            if(book.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found!");
                book.displayBook();
                return;
            }
        }
        System.out.println("Book Title Invalid!");
        return;
}
 

class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        while(true) {
        System.out.println("----LIBRARY MANAGEMENT SYSTEN----");
        System.out.println("1. Add Books : ");
        System.out.println("2. View Books : ");
        System.out.println("3. Issue Book : ");
        System.out.println("4. Return Book : ");
        System.out.println("5. View Issued Books : ");
        System.out.println("6. View Available Books :");
        System.out.println("7. Search Books : ");
        System.out.println("8. Exit ");
        System.out.println("Enter your Choice : ");
        int Choice = scanner.nextInt();
        scanner.nextLine();

        switch(Choice) {
            case 1 :
                System.out.println("Enter BOOK ID : ");
                int bookId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Book title : ");
                String title = scanner.nextLine();
                System.out.println("Enter Book author : ");
                String author = scanner.nextLine();
                library.addBook(new Book(bookId, title, author));
                break;

                case 2 :
                    library.viewBook();
                    break;

                    case 3 :
                        System.out.println("Enter Book ID to Issue Book : ");
                        library.issueBook(scanner.nextInt());
                        break;

                        case 4 :
                            System.out.println("Enter Book ID to return Book :");
                            library.returnBook(scanner.nextInt());
                            break;

                            case 5 :
                                library.viewIssuedBook();
                                break;

                                case 6 :
                                    library.viewAvailableBook();
                                    break;

                                    case 7 :
                                        library.searchBook();
                                        break;

                                        case 8 :
                                            System.out.println("Exiting........");
                                            System.exit(0);
                                            break;

                                            default :
                                            System.out.println("Invalid choice!Try again");
                                            break;
        }
    }
}
} }
