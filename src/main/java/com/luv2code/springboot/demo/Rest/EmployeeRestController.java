package com.luv2code.springboot.demo.Rest;

import com.luv2code.springboot.demo.Entity.Employee;
import com.luv2code.springboot.demo.service.EmployeeService;
import com.luv2code.springboot.demo.service.EmployeeServiceImpl;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeServiceImpl Employeeservice;
    //inject employee dao

    @Autowired
    public void setEmployeeDAO(EmployeeServiceImpl theEmployeeService) {
        this.Employeeservice = theEmployeeService;
    }

    @GetMapping("/Employees")
    public List<Employee> findAll(){
        return Employeeservice.findAll();
    }

    @GetMapping("/Employees/{employeeid}")
    public Employee find(@PathVariable int employeeid){

        Employee theEmployee = Employeeservice.findById(employeeid);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeid);
        }
        return theEmployee;
    }

    //adding new employee
    @PostMapping("/Employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        theEmployee.setID(0);

        Employee dbEmployee = Employeeservice.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/Employees")
    public Employee UpdateEmpoyee(@RequestBody Employee theEmployee){

        Employee dbEmployee = Employeeservice.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("Employees/{employeeid}")
    public String deleteEmployee(@PathVariable int employeeid){
        Employee theEmplyoee = Employeeservice.findById(employeeid);

        if(theEmplyoee == null){
            throw new RuntimeException("Employee is not found - " + employeeid);
        }
        Employeeservice.Delete(employeeid);


        return "Deleted employee id - "+ employeeid;
    }
    //expose employees and return a list of employees
}
