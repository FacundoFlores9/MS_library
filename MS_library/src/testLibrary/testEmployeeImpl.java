package testLibrary;
import interfaces.*;
import services.*;
import entities.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class testEmployeeImpl {


    public void createEmployeeFn() {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        interfaceEmployee empl = new serviceEmployeeImpl();

        System.out.println("Enter the person's ID: ");
        employee.setIdentification(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter the name: ");
        employee.setName(scanner.nextLine());
        System.out.println("Enter the last name: ");
        employee.setLast_name(scanner.nextLine());
        System.out.println("Enter the marital status: ");
        employee.setMarital_status(scanner.nextLine());
        System.out.println("Enter the sector: ");
        employee.setSector(scanner.nextLine());
        System.out.println("Enter the year of incorporation: ");
        int year = scanner.nextInt();
        System.out.println("Enter the month of incorporation: ");
        int month = scanner.nextInt();
        System.out.println("Enter the day of incorporation: ");
        int day = scanner.nextInt();
        employee.setYear_incorporation(new Date(year - 1900, month, day));

        try {
            empl.createEmployee(employee);
            System.out.println("-----------------------------");
            System.out.println("Employee created successfully");
            System.out.println("-----------------------------");
        } catch (Exception e) {
            System.err.println("There was an error creating a user: " + e.getMessage());
        }
    }
    public void getAllEmployeeFn() {
        interfaceEmployee interfaceE = new serviceEmployeeImpl();
        try {
            List<Employee> listEmployee = interfaceE.getAllEmployee();
            System.out.printf("%-20s%-20s%-25s%-20s%-20s%-20s%-20s\n", "Identification", "Name", "Last_Name", "Marital_Status", "employee_number", "year_incorporation", "sector");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

            for (Employee employee : listEmployee) {
                System.out.printf("%-20s%-20s%-25s%-20s%-20s%-20s%-20s\n",
                        employee.getIdentification(), employee.getName(), employee.getLast_name(), employee.getMarital_status(), employee.getEmployee_number(), employee.getYear_incorporation(), employee.getSector());
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            System.err.println("There was an error getting all employees: " + e.getMessage());
        }
    }
    public void updateEmployeeFn() {
        Scanner scanner = new Scanner(System.in);
        interfaceEmployee interfaceE = new serviceEmployeeImpl();
        Employee employee = new Employee();

        System.out.print("Enter the person's identification: ");
        employee.setIdentification(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter the name: ");
        employee.setName(scanner.nextLine());
        System.out.print("Enter the last name: ");
        employee.setLast_name(scanner.nextLine());
        System.out.print("Enter the marital status: ");
        employee.setMarital_status(scanner.nextLine());

        System.out.println("Enter the employee number: ");
        employee.setEmployee_number(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter the year of incorporation: ");
        int year = scanner.nextInt();
        System.out.println("Enter the month of incorporation: ");
        int month = scanner.nextInt();
        System.out.println("Enter the day of incorporation: ");
        int day = scanner.nextInt();
        employee.setYear_incorporation(new Date(year - 1900, month, day));
        scanner.nextLine();
        System.out.println("Enter the sector: ");
        employee.setSector(scanner.nextLine());

        try {
            interfaceE.updateEmployee(employee);
            System.out.println("--------------------------------------");
            System.out.println("The employee was updated successfully");
            System.out.println("--------------------------------------");
        }catch (Exception e){
            System.err.println("There was an error updating the employee: " + e.getMessage());
        }
    }
    public void deleteEmployeeFn() {
        Scanner scanner = new Scanner(System.in);
        interfaceEmployee interfaceE = new serviceEmployeeImpl();
        Employee employee = new Employee();
        System.out.println("Enter the person's identification: ");
        employee.setIdentification(scanner.nextInt());
        System.out.println("Enter the employee id: ");
        employee.setEmployee_number(scanner.nextInt());

        try {
            interfaceE.deleteEmployee(employee);
            System.out.println("---------------------------------");
            System.out.println("Employee was deleted Successfully");
            System.out.println("---------------------------------");
        }catch (Exception e){
            System.err.println("There was an error deleting the employee: " + e.getMessage());
        }
    }












}