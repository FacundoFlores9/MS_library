package entities;
import java.util.ArrayList;
import java.util.List;

public class User extends People {

    private int client_number;
    private int books_rented_now;
    private int total_books_rented;


    public User(int identification, String name, String last_name, String marital_status, int client_number, int books_rented_now, int total_books_rented) {
        super(identification, name, last_name, marital_status);
        this.client_number = client_number;
        this.books_rented_now = books_rented_now;
        this.total_books_rented = total_books_rented;

    }

    public User() {
    }

    public int getClient_number() {
        return client_number;
    }

    public void setClient_number(int client_number) {
        this.client_number = client_number;
    }

    public int getBooks_rented_now() {
        return books_rented_now;
    }

    public void setBooks_rented_now(int books_rented_now) {
        this.books_rented_now = books_rented_now;
    }

    public int getTotal_books_rented() {
        return total_books_rented;
    }

    public void setTotal_books_rented(int total_books_rented) {
        this.total_books_rented = total_books_rented;
    }

}
