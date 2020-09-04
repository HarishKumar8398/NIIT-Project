package com.niit.Middleware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Mainproject.model1.Employee;
import com.niit.Mainproject.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
	
	@Autowired
private EmployeeService  employeeService;
	
	@GetMapping
	public List<Employee> listAllEmployee(){
		List<Employee> emp=employeeService.getEmployeeList();
		return emp;
	}
	
	@PostMapping
	public ResponseEntity<Void> addEmployee(@RequestBody Employee emp)
	{
		if(employeeService.getEmployee(emp.getEmpId())==null)
		{
			employeeService.addEmployee(emp);
			System.out.println("Inside postmapping");
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			
		}
	}
	
	@PutMapping
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee emp)
	{
		if(employeeService.getEmployee(emp.getEmpId())!=null)
		{
			employeeService.updateEmployee(emp);
			System.out.println("Inside putmapping");
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			
		}
	}

	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable ("empId") int empId)
	{
		if(employeeService.getEmployee(empId)!=null)
		{
			employeeService.deleteEmployee(empId);
			System.out.println("Inside deletemapping");
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			
		}
	}

	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable ("empId") int empId)
	{
		if(employeeService.getEmployee(empId)!=null)
		{
			employeeService.getEmployee(empId);
			System.out.println("Inside getmapping");
			return new ResponseEntity<Employee>(employeeService.getEmployee(empId),HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
			
		}
	}

}


