package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private static List<Employee> employees = new ArrayList<Employee>(){
        {

        }
    };

    public static List<Employee> getEmployees() {
        return employees;
    }

    public Employee queryEmployeeById(int id){
        Optional<Employee> optionalEmployee = getEmployees().stream()
                .filter(e -> e.getId() == id)
                .findAny();
        return optionalEmployee.orElse(null);
    }
//    public static List<Employee> mockData(){
//
//    }
}
