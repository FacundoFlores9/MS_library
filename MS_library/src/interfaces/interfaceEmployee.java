package interfaces;

import entities.Employee;

import java.util.List;

public interface interfaceEmployee {

    public void createEmployee(Employee employee) throws Exception;
    List<Employee> getAllEmployee() throws Exception;
    public void updateEmployee(Employee employee) throws Exception;
    public void deleteEmployee(Employee employee) throws Exception;

}
