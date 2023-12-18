package services;
import entities.*;
import interfaces.interfaceBook;
import db.dbConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class serviceBookImpl extends dbConnection implements interfaceBook{
    @Override
    public void createBook(Book book) throws Exception {
        try{
            this.openConnection();
            PreparedStatement stBook = this.connection.prepareStatement("INSERT INTO books(title, gender, author, year_of_publication) VALUES(?,?,?,?)");
            stBook.setString(1,  book.getTitle());
            stBook.setString(2, book.getGender());
            stBook.setString(3, book.getAuthor());
            stBook.setDate(4, new Date(book.getYear_of_publication().getTime()));
            stBook.executeUpdate();
            stBook.close();
        }catch (SQLException e){
            throw new Exception(e);
        }finally {
            this.closeConnection();
        }
    }
    @Override
    public void loanBook(Book book, User user) throws Exception {
        try{
            this.openConnection();
            PreparedStatement stBook = this.connection.prepareStatement("UPDATE books SET Users_client_number = ? WHERE book_id = ?");
            stBook.setInt(1, book.getUsers_client_number());
            stBook.setInt(2, book.getBook_id());
            stBook.executeUpdate();
            stBook.close();

            PreparedStatement stUser = this.connection.prepareStatement("UPDATE users SET books_rented_now = books_rented_now + 1, total_books_rented = total_books_rented + 1 WHERE client_number = ?");
            stUser.setInt(1, user.getClient_number());
            stUser.executeUpdate();
            stUser.close();

        }catch (SQLException e){
            throw new Exception(e);
        }finally {
            this.closeConnection();
        }
    }
    @Override
    public void returnBook(Book book, User user) throws Exception {
        try{
            this.openConnection();
            PreparedStatement stBook = this.connection.prepareStatement("UPDATE books SET Users_client_number = null WHERE book_id = ?;");
            stBook.setInt(1, book.getBook_id());
            stBook.executeUpdate();
            stBook.close();

            PreparedStatement stUser = this.connection.prepareStatement("UPDATE users SET books_rented_now = books_rented_now - 1 WHERE client_number = ?");
            stUser.setInt(1, user.getClient_number());
            stUser.executeUpdate();
            stUser.close();
        }catch (SQLException e){
            throw new Exception(e);
        }finally {
            this.closeConnection();
        }
    }
    @Override
    public List<Book> getAllLoan() throws Exception{
        try{
            this.openConnection();
            PreparedStatement stBook = this.connection.prepareStatement("SELECT * FROM books WHERE Users_client_number IS NOT NULL;");
            ResultSet rs = stBook.executeQuery();
            List<Book> listBook = new ArrayList<>();

            while (rs.next()) {
                Book book = new Book(rs.getInt("book_id"),rs.getString("title"),rs.getString("gender"),rs.getString("author"),rs.getDate("year_of_publication"),rs.getInt("users_client_number"));
                listBook.add(book);

            }
            stBook.close();
            rs.close();
            return listBook;
        }catch (SQLException e){
            throw new Exception(e);
        }finally {
            this.closeConnection();
        }
    }
    @Override
    public List<Book> getBookGender(Book book) throws Exception {
        try{
            this.openConnection();
            PreparedStatement stBook = this.connection.prepareStatement("SELECT * FROM books WHERE gender = ?;");
            stBook.setString(1, book.getGender());
            ResultSet rs = stBook.executeQuery();
            List<Book> listBook = new ArrayList<>();

            while (rs.next()){
                Book genderBook = new Book(rs.getInt("book_id"),rs.getString("title"),rs.getString("gender"),rs.getString("author"),rs.getDate("year_of_publication"),rs.getInt("Users_client_number"));
                listBook.add(genderBook);
            }
            stBook.close();
            rs.close();
            return listBook;
        }catch (SQLException e){
            throw new Exception(e);
        }finally {
            this.closeConnection();
        }
    }
    @Override
    public List<Book> getAllBook() throws Exception {
        try {
            this.openConnection();
            PreparedStatement stBook = this.connection.prepareStatement("SELECT * FROM books");
            ResultSet rs = stBook.executeQuery();
            List<Book> listBook = new ArrayList<>();

            while (rs.next()) {
                Book book = new Book(rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("gender"),
                        rs.getString("author"),
                        rs.getDate("year_of_publication"),
                        rs.getInt("Users_client_number"));
                listBook.add(book);
            }
            stBook.close();
            rs.close();
            return listBook;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            this.closeConnection();
        }
    }
    @Override
    public void updateBook(Book book) throws Exception {
        try {
            this.openConnection();
            PreparedStatement stBook = connection.prepareStatement("UPDATE books SET title = ?, gender = ?, author = ?, year_of_publication = ? WHERE book_id = ?");
            stBook.setString(1, book.getTitle());
            stBook.setString(2, book.getGender());
            stBook.setString(3, book.getAuthor());
            stBook.setDate(4, new Date(book.getYear_of_publication().getTime()));
            stBook.setInt(5, book.getBook_id());
            stBook.executeUpdate();
            stBook.close();
        }catch (SQLException e){
            throw new Exception(e);
        }finally {
            this.closeConnection();
        }
    }
    @Override
    public void deleteBook(Book book) throws Exception{
        try {
            this.openConnection();
            PreparedStatement stCheck = connection.prepareStatement("SELECT Users_client_number FROM books WHERE book_id = ?");
            stCheck.setInt(1, book.getBook_id());
            ResultSet rs = stCheck.executeQuery();

            if (rs.next()) {
                Integer clientNumber = (Integer) rs.getObject("Users_client_number");

                if (clientNumber != null) {
                    throw new Exception("The book cannot be deleted as it is currently rented.");
                }
            }
            PreparedStatement stBook = connection.prepareStatement("DELETE FROM books WHERE book_id = ?");
            stBook.setInt(1, book.getBook_id());
            stBook.executeUpdate();
            stBook.close();

        }catch (SQLException e){
            throw new Exception(e);
        }finally {
            this.closeConnection();
        }
    }
}
