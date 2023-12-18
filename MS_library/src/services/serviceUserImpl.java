package services;
import db.dbConnection;
import entities.*;
import interfaces.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class serviceUserImpl extends dbConnection implements interfaceUser {

    @Override
    public void createUser(User user) throws Exception {
        try{
            this.openConnection();
            PreparedStatement stPeople = this.connection.prepareStatement("INSERT INTO people(identification, name, last_name, marital_status) VALUES(?,?,?,?)");
            stPeople.setInt(1,  user.getIdentification());
            stPeople.setString(2, user.getName());
            stPeople.setString(3, user.getLast_name());
            stPeople.setString(4, user.getMarital_status());
            stPeople.executeUpdate();
            stPeople.close();

            PreparedStatement stUser = this.connection.prepareStatement("INSERT INTO users (books_rented_now, total_books_rented, People_identification) VALUES(?,?,?) ");
            stUser.setInt(1, user.getBooks_rented_now());
            stUser.setInt(2, user.getTotal_books_rented());
            stUser.setInt(3, user.getIdentification());
            stUser.executeUpdate();
            stUser.close();

        }catch (SQLException e){
            throw new Exception(e);
        }finally {
            this.closeConnection();
        }
    }
    @Override
    public List<User> getUserLoan() throws Exception {
        try {
            this.openConnection();
                PreparedStatement stUser = this.connection.prepareStatement("SELECT DISTINCT people.*, users.client_number, users.books_rented_now, users.total_books_rented\n" +
                        "FROM people\n" +
                        "JOIN users ON identification = people_identification\n" +
                        "JOIN books ON users.client_number = books.Users_client_number\n" +
                        "WHERE users.client_number IS NOT NULL;");
            ResultSet rs = stUser.executeQuery();
            List<User> listUser = new ArrayList<>();

            while (rs.next()) {
                User user = new User(
                        rs.getInt("identification"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("marital_status"),
                        rs.getInt("client_number"),
                        rs.getInt("books_rented_now"),
                        rs.getInt("total_books_rented")
                );
                listUser.add(user);
            }
            stUser.close();
            rs.close();
            return listUser;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            this.closeConnection();
        }
    }

    public List<User> getAllUser() throws Exception {
        try {
            this.openConnection();
            PreparedStatement stUser = this.connection.prepareStatement("SELECT people.*, users.client_number, users.books_rented_now, users.total_books_rented\n" +
                    "FROM people\n" +
                    "INNER JOIN users ON people.identification = users.people_identification;");
            ResultSet rs = stUser.executeQuery();
            List<User> listUser = new ArrayList<>();

            while (rs.next()) {
                User user = new User(rs.getInt("identification"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("marital_status"),
                        rs.getInt("client_number"),
                        rs.getInt("books_rented_now"),
                        rs.getInt("total_books_rented")
                );
                listUser.add(user);
            }
            stUser.close();
            rs.close();
            return listUser;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            this.closeConnection();
        }
    }
    @Override
    public void updateUser(User user) throws Exception {
        try {
            this.openConnection();
            PreparedStatement stPeople = connection.prepareStatement("UPDATE people SET identification = ?, name = ?, last_name = ?, marital_status = ? WHERE identification = ?");
            stPeople.setInt(1, user.getIdentification());
            stPeople.setString(2, user.getName());
            stPeople.setString(3, user.getLast_name());
            stPeople.setString(4, user.getMarital_status());
            stPeople.setInt(5, user.getIdentification());
            stPeople.executeUpdate();
            stPeople.close();

        }catch (SQLException e){
            throw new Exception(e);
        }finally {
            this.closeConnection();
        }
    }
    @Override
    public void deleteUser(User user) throws Exception {
        try {
            this.openConnection();
            PreparedStatement stPeople = connection.prepareStatement("delete from people where identification = ?");
            stPeople.setInt(1, user.getIdentification());
            stPeople.executeUpdate();
            stPeople.close();

            PreparedStatement stUser = connection.prepareStatement("delete from users where client_number = ?");
            stUser.setInt(1, user.getClient_number());
            stUser.executeUpdate();
            stUser.close();
        }catch (SQLException e){
            throw new Exception(e);
        }finally {
            this.closeConnection();
        }
    }
}

