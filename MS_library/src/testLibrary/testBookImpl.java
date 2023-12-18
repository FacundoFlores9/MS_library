package testLibrary;
import db.dbConnection;
import entities.*;
import interfaces.*;
import services.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class testBookImpl {
    public void createBookFn(){
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        interfaceBook bk = new serviceBookImpl();
        System.out.print("Enter the book title: ");
        book.setTitle(scanner.nextLine());
        System.out.print("Enter the genre of the book: ");
        book.setGender(scanner.nextLine());
        System.out.print("Enter the author of the book: ");
        book.setAuthor(scanner.nextLine());
        System.out.print("Enter the publication year of the book: ");
        int year = scanner.nextInt();
        System.out.print("Enter the publication month of the book (0-11): ");
        int month = scanner.nextInt();
        System.out.print("Enter the publication day of the book: ");
        int day = scanner.nextInt();
        book.setYear_of_publication(new Date(year - 1900, month, day));

        try {
            bk.createBook(book);
            System.out.println("----------------------------");
            System.out.println("Book created successfully");
            System.out.println("----------------------------");
        }catch (Exception e){
            System.err.println("There was an error creating the book: " + e.getMessage());
        }
    }
    public void loanBookFn (){
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        User user = new User();
        interfaceBook bk1 = new serviceBookImpl();
        System.out.println("Enter the customer number: ");
        user.setClient_number(scanner.nextInt());
        System.out.println("Enter the book ID: ");
        book.setBook_id(scanner.nextInt());
        book.setUsers_client_number(user.getClient_number());

        try {
            bk1.loanBook(book, user);
            System.out.println("----------------------------");
            System.out.println("Book rented successfully");
            System.out.println("----------------------------");
        }catch (Exception e){
            System.err.println("There was an error renting the book: " + e.getMessage());
        }
    }
    public static void returnBookFn(){
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        User user = new User();
        interfaceBook bk2 = new serviceBookImpl();
        System.out.println("Enter the book ID: ");
        book.setBook_id(scanner.nextInt());
        System.out.println("Enter the customer number: ");
        user.setClient_number(scanner.nextInt());

        try {
            bk2.returnBook(book, user);
            System.out.println("----------------------------");
            System.out.println("Book returned successfully");
            System.out.println("----------------------------");
        }catch (Exception e){
            System.err.println("There was an error returning the book: " + e.getMessage());
        }
    }
    public void getAllLoanFn(){
        interfaceBook interfaceB = new serviceBookImpl();
        try {
           List<Book> listBook = interfaceB.getAllLoan();
            System.out.println("Rented Books: ");
            System.out.println(" ");
            System.out.printf("%-10s%-30s%-15s%-20s%-20s\n", "Book_id", "Title", "Gender", "Author", "Year");
            System.out.println("--------------------------------------------------------------------------------------------------------------");

           for (Book book : listBook) {
               System.out.printf("%-10s%-30s%-15s%-20s%-20s\n",
                       book.getBook_id(), book.getTitle(), book.getGender(), book.getAuthor(), book.getYear_of_publication());
               System.out.println("--------------------------------------------------------------------------------------------------------------");
           }
        } catch (Exception e) {
            System.err.println("There was an error listing the rented books: " + e.getMessage());
        }
    }
    public void getBookGenderFn() {
        Scanner scanner = new Scanner(System.in);
        Book genderBook = new Book();

        System.out.println("Enter the book genre: ");
        genderBook.setGender(scanner.nextLine());

        interfaceBook interfaceB = new serviceBookImpl();
        try {
            List<Book> listBook = interfaceB.getBookGender(genderBook);
            System.out.printf("%-10s%-30s%-15s%-20s%-20s%-30s\n", "Book_id", "Title", "Gender", "Author", "Year", "Status");
            System.out.println("--------------------------------------------------------------------------------------------------------------");

            for (Book book : listBook) {
                String rentedStatus = (book.getUsers_client_number() != 0) ? "Rented" : "Available";

                System.out.printf("%-10s%-30s%-15s%-20s%-20s%-30s\n",
                        book.getBook_id(), book.getTitle(), book.getGender(), book.getAuthor(), book.getYear_of_publication(), rentedStatus);
                System.out.println("--------------------------------------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            System.err.println("There was an error listing the books by genre: " + e.getMessage());
        }
    }

    public void getAllBookFn() {
        interfaceBook interfaceB = new serviceBookImpl();
        try {
            List<Book> listBook = interfaceB.getAllBook();
            System.out.printf("%-10s%-30s%-15s%-20s%-20s%-30s\n", "Book_id", "Title", "Gender", "Author", "Year", "Status");
            System.out.println("--------------------------------------------------------------------------------------------------------------");

            for (Book book : listBook) {
                String rentedStatus = (book.getUsers_client_number() != 0) ? "Rented" : "Available";

                System.out.printf("%-10s%-30s%-15s%-20s%-20s%-30s\n",
                        book.getBook_id(), book.getTitle(), book.getGender(), book.getAuthor(), book.getYear_of_publication(), rentedStatus);
                System.out.println("--------------------------------------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            System.err.println("There was an error listing the books: " + e.getMessage());
        }
    }
    public void updateBookFn() {
        Scanner scanner = new Scanner(System.in);
        interfaceBook interfaceB = new serviceBookImpl();
        Book book = new Book();
        System.out.print("Enter the book title: ");
        book.setTitle(scanner.nextLine());
        System.out.print("Enter the book genre: ");
        book.setGender(scanner.nextLine());
        System.out.print("Enter the book author: ");
        book.setAuthor(scanner.nextLine());
        System.out.print("Enter the publication year of the book: ");
        int year = scanner.nextInt();
        System.out.print("Enter the publication month of the book (0-11): ");
        int month = scanner.nextInt();
        System.out.print("Enter the publication day of the book: ");
        int day = scanner.nextInt();
        book.setYear_of_publication(new Date(year - 1900, month, day));
        System.out.print("Enter the book ID: ");
        book.setBook_id(scanner.nextInt());

        try {
            interfaceB.updateBook(book);
            System.out.println("-----------------------------------");
            System.out.println("The book was updated successfully");
            System.out.println("-----------------------------------");

        }catch (Exception e){
            System.err.println("There was an error updating the book: " + e.getMessage());
        }
    }
    public void deleteBookFn() {
        Scanner scanner = new Scanner(System.in);
        interfaceBook interfaceB = new serviceBookImpl();
        Book book = new Book();

        System.out.print("Enter the book ID: ");
        book.setBook_id(scanner.nextInt());
        try {
            interfaceB.deleteBook(book);
            System.out.println("-------------------------------");
            System.out.println("The book was deleted successfully");
            System.out.println("-------------------------------");
        }catch (Exception e){
            System.err.println("There was an error deleting the book: " + e.getMessage());
        }
    }
}
