package interfaces;
import entities.*;

import java.util.List;

public interface interfaceBook {

    public void createBook(Book book) throws Exception;

    public void loanBook(Book book, User user) throws Exception;

    public void returnBook(Book book, User user) throws Exception;

    List<Book> getAllLoan() throws Exception;

    List<Book> getBookGender(Book book) throws Exception;

    List<Book> getAllBook() throws Exception;

    public void updateBook(Book book) throws Exception;

    public void deleteBook(Book book) throws Exception;

}
