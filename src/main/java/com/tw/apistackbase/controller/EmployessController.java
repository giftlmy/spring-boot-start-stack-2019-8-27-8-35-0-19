package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployessController {
    @GetMapping
    public ResponseEntity<List<Employee>> queryEmpolyees(){
        List<Employee> list = new ArrayList<Employee>();
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("123");
        employee.setAge(14);
        employee.setSex("男");
        list.add(employee);
        return ResponseEntity.ok(list);
    }

}
