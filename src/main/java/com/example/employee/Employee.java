package com.example.employee;

public class Employee {
    private String empid;
    private String firstname;
    private String lastname;
    private String primaryskill;
    private String location;

    public Employee() {}

    public Employee(String empid, String firstname, String lastname, String primaryskill, String location) {
        this.empid = empid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.primaryskill = primaryskill;
        this.location = location;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPrimaryskill() {
        return primaryskill;
    }

    public void setPrimaryskill(String primaryskill) {
        this.primaryskill = primaryskill;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
