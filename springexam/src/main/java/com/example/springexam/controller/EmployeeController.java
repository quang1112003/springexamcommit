package com.example.springexam.controller;

import com.example.springexam.dao.EmployeeRepo;
import com.example.springexam.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;

    @RequestMapping("/add")
    public String addPage(){
        return "add";
    }

    @RequestMapping("/saveEmp")
    @ResponseBody
    public ModelAndView createEmployee(Employees employees) {
        employeeRepo.save(employees);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/")
    public ModelAndView listEmp(){
        ModelAndView mv = new ModelAndView();
        List<Employees> emplist = employeeRepo.findAll();
        mv.addObject("emp",emplist);
        mv.setViewName("list");
        return mv;
    }

    @GetMapping("/search")
    public ModelAndView searchByName(@RequestParam("name") String name) {
        ModelAndView mv = new ModelAndView();
        List<Employees> empList = employeeRepo.findByName(name);
        mv.addObject("emp", empList);
        mv.setViewName("list");
        return mv;
    }
}
