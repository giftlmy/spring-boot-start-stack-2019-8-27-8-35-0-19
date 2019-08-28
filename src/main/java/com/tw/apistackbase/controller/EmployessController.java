package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployessController {
    @GetMapping
    public ResponseEntity<List<Employee>> queryEmpolyees(@RequestParam("name") String name){
        List<Employee> list = new ArrayList<Employee>();
        Employee employee = new Employee(1, "刘梦瑶", 18, "女");
        list.add(employee);
        Employee employee1 = new Employee(2, "赵XX", 18, "男");
        list.add(employee1);
        if(name == null){
            return ResponseEntity.ok(list);
        }else{
            List<Employee> listresult = new ArrayList<Employee>();
            for (Employee e : list) {
                if (e.getName().contains(name))
                    listresult.add(e);
            }
            return ResponseEntity.ok(listresult);
        }

    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> queryOneEmployee(@PathVariable int id) {
        List<Employee> list = new ArrayList<Employee>();
        Employee employee = new Employee(1, "刘梦瑶", 18, "女");
        list.add(employee);
        Employee employee1 = new Employee(2, "赵非凡", 18, "男");
        list.add(employee1);
        Employee employee2 = new Employee();
        for (Employee e : list) {

            if (e.getId() == id) employee2 = e;
        }
        return ResponseEntity.ok(employee2);
    }
}
