package testLibrary;
import interfaces.*;
import services.*;
import entities.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class testUserImpl {
    public void createUserFn() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        interfaceUser usr = new serviceUserImpl();

        System.out.println("Enter the identification: ");
        user.setIdentification(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter the name: ");
        user.setName(scanner.nextLine());
        System.out.println("Enter the last name: ");
        user.setLast_name(scanner.nextLine());
        System.out.println("Enter the marital status: ");
        user.setMarital_status(scanner.nextLine());
        user.setBooks_rented_now(0);
        user.setTotal_books_rented(0);
        try {
            usr.createUser(user);
            System.out.println("-----------------------------");
            System.out.println("User created successfully");
            System.out.println("-----------------------------");
        } catch (Exception e) {
            System.err.println("There was an error creating a user: " + e.getMessage());
        }
    }
    public void getUserLoanFn() {
        interfaceUser interfaceU = new serviceUserImpl();
        try {
            List<User> listUser = interfaceU.getUserLoan();
            System.out.printf("%-20s%-20s%-25s%-20s%-20s%-20s%-20s\n", "Identification", "Name", "Last_Name", "Marital_Status", "Client_Number", "Books_Rented_Now", "Total_books_rented");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

            for (User user : listUser) {
                System.out.printf("%-20s%-20s%-25s%-20s%-20s%-20s%-20s\n",
                        user.getIdentification(), user.getName(), user.getLast_name(), user.getMarital_status(), user.getClient_number(), user.getBooks_rented_now(), user.getTotal_books_rented());
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            System.err.println("There was an error retrieving users with rented books: " + e.getMessage());
        }
    }
    public void getAllUserFn() {
        interfaceUser interfaceU = new serviceUserImpl();
        try {
            List<User> listUser = interfaceU.getAllUser();
            System.out.printf("%-20s%-20s%-25s%-20s%-20s%-20s%-20s\n", "Identification", "Name", "Last_Name", "Marital_Status", "Client_Number", "Books_Rented_Now", "Total_books_rented");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

            for (User user : listUser) {
                System.out.printf("%-20s%-20s%-25s%-20s%-20s%-20s%-20s\n",
                        user.getIdentification(), user.getName(), user.getLast_name(), user.getMarital_status(), user.getClient_number(), user.getBooks_rented_now(), user.getTotal_books_rented());
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            System.err.println("There was an error retrieving the list of users: " + e.getMessage());
        }
    }
    public void updateUserFn() {
        Scanner scanner = new Scanner(System.in);
        interfaceUser interfaceU = new serviceUserImpl();
        User user = new User();

        System.out.print("Enter the identification: ");
        user.setIdentification(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter the name: ");
        user.setName(scanner.nextLine());
        System.out.print("Enter the last name: ");
        user.setLast_name(scanner.nextLine());
        System.out.print("Enter the marital status: ");
        user.setMarital_status(scanner.nextLine());

        try {
            interfaceU.updateUser(user);
            System.out.println("-----------------------------");
            System.out.println("The user was updated successfully");
            System.out.println("-----------------------------");
        }catch (Exception e){
            System.err.println("There was an error updating the user: " + e.getMessage());
        }
    }
    public void deleteUserFn() {
        Scanner scanner = new Scanner(System.in);
        interfaceUser interfaceU = new serviceUserImpl();
        User user = new User();
        System.out.println("Enter the ID of the person: ");
        user.setIdentification(scanner.nextInt());
        System.out.println("Enter the user ID: ");
        user.setClient_number(scanner.nextInt());

        try {
            interfaceU.deleteUser(user);
            System.out.println("-----------------------------------");
            System.out.println("The user was deleted successfully");
            System.out.println("-----------------------------------");
        }catch (Exception e){
            System.err.println("There was an error deleting the user: " + e.getMessage());
        }
    }
}


