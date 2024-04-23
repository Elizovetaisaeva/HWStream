package org.example.hwstream.steam;

import java.util.Objects;
import java.util.Random;
import java.util.function.ObjDoubleConsumer;

public class Employee {
    private String firstName;
    private String lastName;
    private double selary;
    private int department;

    public Employee(String firstName, String lastName, Double selary,
                    int department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.selary = selary;
        this.department = department;
    }
    public Employee(String firstName, String lastName) {
        Random random = new Random();
        this.firstName = firstName;
        this.lastName = lastName;
        this.selary = random.nextInt(10000) + 1000;
        this.department = random.nextInt(5) + 1;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSelary() {
        return selary;
    }

    public int getDepartment() {
        return department;
    }

    public void setSelary(double selary) {
        this.selary = selary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(selary, employee.selary) == 0 && department == employee.department && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, selary, department);
    }
}


