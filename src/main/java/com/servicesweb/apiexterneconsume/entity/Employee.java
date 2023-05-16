package com.servicesweb.apiexterneconsume.entity;

public class Employee {
    private long id;
    private String name;
    private String mobileNo;
    private Long salary;

    public Employee(long id, String name, String mobileNo, Long salary) {
        this.id = id;
        this.name = name;
        this.mobileNo = mobileNo;
        this.salary = salary;
    }

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public Long getSalary() {
        return salary;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
