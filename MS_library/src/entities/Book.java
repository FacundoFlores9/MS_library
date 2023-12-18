package entities;

import java.util.Date;

public class Book {
    private int book_id;
    private String title;
    private String gender;
    private String author;
    private Date year_of_publication;
    private int users_client_number;

    public Book(int book_id, String title, String gender, String author, Date year_of_publication , int users_client_number) {
        this.book_id = book_id;
        this.title = title;
        this.gender = gender;
        this.author = author;
        this.year_of_publication = year_of_publication;
        this.users_client_number = users_client_number;
    }


    public Book() {
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(Date year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    public int getUsers_client_number() {
        return users_client_number;
    }

    public void setUsers_client_number(int users_client_number) {
        this.users_client_number = users_client_number;
    }
}
