package com.example.springexam.model;

import jakarta.persistence.*;

@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "wage")
    private int wage;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public Employees(String name, int wage) {
        this.name = name;
        this.wage = wage;
    }

    public Employees(){
        super();
    }
}
