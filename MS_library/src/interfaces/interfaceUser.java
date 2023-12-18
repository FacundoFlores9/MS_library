package interfaces;

import entities.Book;
import entities.User;
import services.*;

import java.util.List;

public interface interfaceUser {

    public void createUser(User user)throws Exception;
    List<User> getUserLoan() throws Exception;
    List<User> getAllUser() throws Exception;
    public void updateUser(User user) throws Exception;
    public void deleteUser(User user) throws Exception;


}
