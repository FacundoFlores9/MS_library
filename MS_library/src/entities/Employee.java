package entities;
import java.util.Date;
import java.time.LocalDate;

public class Employee extends People {

    private int employee_number;
    private Date year_incorporation;
    private String sector;


    public Employee(int identification, String name, String last_name, String marital_status, int employee_number, Date year_incorporation, String sector) {
        super(identification, name, last_name, marital_status);
        this.employee_number = employee_number;
        this.year_incorporation = year_incorporation;
        this.sector = sector;
    }

    public Employee() {

    }

    public int getEmployee_number() {
        return employee_number;
    }

    public void setEmployee_number(int employee_number) {
        this.employee_number = employee_number;
    }

    public Date getYear_incorporation() {
        return year_incorporation;
    }

    public void setYear_incorporation(Date year_incorporation) {
        this.year_incorporation = year_incorporation;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }





}
