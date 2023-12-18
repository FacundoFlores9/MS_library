package services;
import entities.*;
import interfaces.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.dbConnection;
public class serviceEmployeeImpl extends dbConnection implements interfaceEmployee {
    @Override
    public void createEmployee(Employee employee) throws Exception {
        try {
            this.openConnection();
            PreparedStatement stPeople = this.connection.prepareStatement("INSERT INTO people(identification, name, last_name, marital_status) VALUES(?,?,?,?)");
            stPeople.setInt(1, employee.getIdentification());
            stPeople.setString(2, employee.getName());
            stPeople.setString(3, employee.getLast_name());
            stPeople.setString(4, employee.getMarital_status());
            stPeople.executeUpdate();
            stPeople.close();

            PreparedStatement stEmployee = this.connection.prepareStatement("INSERT INTO employees(sector, year_incorporation, People_identification) VALUES(?,?,?)");
            stEmployee.setString(1, employee.getSector());
            stEmployee.setDate(2, new Date(employee.getYear_incorporation().getTime()));
            stEmployee.setInt(3, employee.getIdentification());
            stEmployee.executeUpdate();
            stEmployee.close();

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            this.closeConnection();
        }
    }
    @Override
    public List<Employee> getAllEmployee() throws Exception {
        try {
            this.openConnection();
            PreparedStatement stEmployee = this.connection.prepareStatement("SELECT people.*, employees.employee_number,employees.year_incorporation, employees.sector\n" +
                    "FROM people\n" +
                    "INNER JOIN employees ON people.identification = employees.people_identification;");
            ResultSet rs = stEmployee.executeQuery();
            List<Employee> listEmployee = new ArrayList<>();

            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("identification"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("marital_status"),
                        rs.getInt("employee_number"),
                        rs.getDate("year_incorporation"),
                        rs.getString("sector")
                );
                listEmployee.add(employee);
            }
            stEmployee.close();
            rs.close();
            return listEmployee;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            this.closeConnection();
        }
    }
    @Override
    public void updateEmployee(Employee employee) throws Exception {
        try {
            this.openConnection();
            PreparedStatement stPeople = connection.prepareStatement("UPDATE people SET identification = ?, name = ?, last_name = ?, marital_status = ? WHERE identification = ?");
            stPeople.setInt(1, employee.getIdentification());
            stPeople.setString(2, employee.getName());
            stPeople.setString(3, employee.getLast_name());
            stPeople.setString(4, employee.getMarital_status());
            stPeople.setInt(5, employee.getIdentification());
            stPeople.executeUpdate();
            stPeople.close();

            PreparedStatement stEmployee = connection.prepareStatement("UPDATE employees SET year_incorporation = ?, sector = ? WHERE employee_number = ?");
            stEmployee.setDate(1, new Date(employee.getYear_incorporation().getTime()));
            stEmployee.setString(2, employee.getSector());
            stEmployee.setInt(3, employee.getEmployee_number());
            stEmployee.executeUpdate();
            stEmployee.close();

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            this.closeConnection();
        }
    }
    @Override
    public void deleteEmployee(Employee employee) throws Exception {
        try {
            this.openConnection();
            PreparedStatement stPeople = connection.prepareStatement("delete from people where identification = ?");
            stPeople.setInt(1, employee.getIdentification());
            stPeople.executeUpdate();
            stPeople.close();

            PreparedStatement stEmployee = connection.prepareStatement("delete from employees where employee_number = ?");
            stEmployee.setInt(1, employee.getEmployee_number());
            stEmployee.executeUpdate();
            stEmployee.close();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            this.closeConnection();
        }
    }
}
