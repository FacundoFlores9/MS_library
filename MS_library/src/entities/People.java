package entities;

public abstract class People {

    private int identification;
    private String name;
    private String last_name;
    private String marital_status;

    public People(int identification, String name, String last_name, String marital_status) {
        this.identification = identification;
        this.name = name;
        this.last_name = last_name;
        this.marital_status = marital_status;
    }

    public People() {

    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }


    public void createPeople() {
    }
}

