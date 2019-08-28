package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployessController {
    private static List<Employee> employees = new ArrayList<Employee>(){
        {
            add(new Employee(1, "刘梦瑶", 18, "女"));
            add(new Employee(2, "刘梦瑶", 18, "女"));
            add(new Employee(3, "刘梦瑶", 18, "女"));
            add(new Employee(4, "刘梦瑶", 18, "女"));
        }
    };
    @GetMapping
    public ResponseEntity<List<Employee>> queryEmpolyees(@RequestParam(value = "name",required = false) String name){
        if(name == null){
            return ResponseEntity.ok(employees);
        }else{
            List<Employee> listresult = new ArrayList<Employee>();
            for (Employee e : employees) {
                if (e.getName().contains(name))
                    listresult.add(e);
            }
            return ResponseEntity.ok(listresult);
        }

    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> queryOneEmployee(@PathVariable int id) {

        Employee employee2 = new Employee();
        for (Employee e : employees) {

            if (e.getId() == id) employee2 = e;
        }
        return ResponseEntity.ok(employee2);
    }
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){

        employees.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
