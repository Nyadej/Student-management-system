package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity // a table in the database
@Table(name = "students") // name of the table in the database
public class Student {

    @Id // Marks a field as the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies how the primary key (ID) should be generated - generate a unique value for the id field whenever a new student is added.  The GenerationType.IDENTITY means the database will handle generating the ID.
    private Long id; // declares a private variable id of type Long to store the unique identifier for each student.
    private String name;
    private LocalDate dob;
    private String email;
    @Transient // field should not be saved to the database.
    private Integer age; 

    public Student () {

    }

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    // method to calculate the age from the DOB
    public Integer getAge() {
        // calculates the number of years between the student’s date of birth and the current date
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student[" + "id=" + id + ", name=' " + name + '\'' + ", email=' " + email + '\'' + ", dob=" + dob + ", age=" + age + '}'; 
    }
}
