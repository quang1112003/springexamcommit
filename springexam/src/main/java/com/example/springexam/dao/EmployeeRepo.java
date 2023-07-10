package com.example.springexam.dao;

import com.example.springexam.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employees,Integer> {
    @Query("SELECT u FROM Employees u WHERE u.name = ?1")
    List<Employees> findByName(String name);
}
