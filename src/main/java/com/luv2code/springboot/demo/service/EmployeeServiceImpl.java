package com.luv2code.springboot.demo.service;

import com.luv2code.springboot.demo.Entity.Employee;
import com.luv2code.springboot.demo.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){

        employeeRepository = theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> RESULT = employeeRepository.findById(id);
        Employee theEmployee = null;

        if(RESULT.isPresent()){
            theEmployee = RESULT.get();
        }else{
            throw new RuntimeException("DID not find employee is - " + id);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void Delete(int id) {
        employeeRepository.deleteById(id);
    }
}
