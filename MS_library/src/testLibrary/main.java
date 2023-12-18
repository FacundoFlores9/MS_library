package testLibrary;
import db.dbConnection;
import java.util.Date;
import java.util.Scanner;
import entities.*;
import interfaces.*;
import services.*;

public class main {
    public static void main(String[] args) throws Exception {

        Scanner sn = new Scanner(System.in);
        boolean exit = false;
        int option, optionTwo;

        while (!exit) {
            System.out.println("Write one of the options");
            System.out.println("1. Books");
            System.out.println("2. Users");
            System.out.println("3. Peoples");
            System.out.println("4. Exit");

            option = sn.nextInt();

            switch (option) {
                case 1:
                    System.out.println("1. Load book");
                    System.out.println("2. Update Book");
                    System.out.println("3. Delete Book");
                    System.out.println("4. Rent Book");
                    System.out.println("5. Return Book");
                    System.out.println("6. List all rented books");
                    System.out.println("7. List book by genre");
                    System.out.println("8. List of all books");
                    System.out.println("9. Return");
                    optionTwo = sn.nextInt();

                    switch (optionTwo) {
                        case 1:
                            testBookImpl testBook1 = new testBookImpl();
                            testBook1.createBookFn();
                            break;
                        case 2:
                            testBookImpl testBook2 = new testBookImpl();
                            testBook2.updateBookFn();
                            break;
                        case 3:
                            testBookImpl testBook3 = new testBookImpl();
                            testBook3.deleteBookFn();
                            break;
                        case 4:
                            testBookImpl testBook4 = new testBookImpl();
                            testBook4.loanBookFn();
                            break;
                        case 5:
                            testBookImpl testBook5 = new testBookImpl();
                            testBook5.returnBookFn();
                            break;
                        case 6:
                            testBookImpl testBook6 = new testBookImpl();
                            testBook6.getAllLoanFn();
                            break;
                        case 7:
                            testBookImpl testBook7 = new testBookImpl();
                            testBook7.getBookGenderFn();
                            break;
                        case 8:
                            testBookImpl testBook8 = new testBookImpl();
                            testBook8.getAllBookFn();
                            break;
                        case 9:
                            break;
                        default:
                            System.out.println("Only numbers between 1 and 9");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1. Load user");
                    System.out.println("2. Users with rented books");
                    System.out.println("3. List users");
                    System.out.println("4. Update user");
                    System.out.println("5. Delete user");
                    System.out.println("6. Return");
                    System.out.println("Write one of the options");

                    optionTwo = sn.nextInt();
                    switch (optionTwo) {
                        case 1:
                            testUserImpl testUser1 = new testUserImpl();
                            testUser1.createUserFn();
                            break;
                        case 2:
                            testUserImpl testUser2 = new testUserImpl();
                            testUser2.getUserLoanFn();
                            break;
                        case 3:
                            testUserImpl testUser3 = new testUserImpl();
                            testUser3.getAllUserFn();
                            break;
                        case 4:
                            testUserImpl testUser4 = new testUserImpl();
                            testUser4.updateUserFn();
                            break;
                        case 5:
                            testUserImpl testUser5 = new testUserImpl();
                            testUser5.deleteUserFn();
                            break;
                        case 6:
                            break;
                        default:
                            System.out.println("Only numbers between 1 and 6");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1. Load Employee");
                    System.out.println("2. List Employees");
                    System.out.println("3. Update Employee");
                    System.out.println("4. Delete Employee");
                    System.out.println("5. Return");
                    System.out.println("Write one of the options");

                    optionTwo = sn.nextInt();

                    switch (optionTwo) {
                        case 1:
                            testEmployeeImpl testEmployee1 = new testEmployeeImpl();
                            testEmployee1.createEmployeeFn();
                            break;
                        case 2:
                            testEmployeeImpl testEmployee2 = new testEmployeeImpl();
                            testEmployee2.getAllEmployeeFn();
                            break;
                        case 3:
                            testEmployeeImpl testEmployee3 = new testEmployeeImpl();
                            testEmployee3.updateEmployeeFn();
                            break;
                        case 4:
                            testEmployeeImpl testEmployee4 = new testEmployeeImpl();
                            testEmployee4.deleteEmployeeFn();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Only numbers between 1 and 5");
                            break;
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Only numbers between 1 and 4");
            }
        }
    }
}

























