package com.luv2code.springboot.demo.dao;

import com.luv2code.springboot.demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //thats it!!!
}
