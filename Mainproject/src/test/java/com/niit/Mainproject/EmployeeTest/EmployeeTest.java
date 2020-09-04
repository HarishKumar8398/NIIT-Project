package com.niit.Mainproject.EmployeeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.Mainproject.model1.Employee;
import com.niit.Mainproject.service.EmployeeService;
import com.niit.Mainproject.configure.DBConfig;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=DBConfig.class)
 public class EmployeeTest {
	@Autowired
	private static  EmployeeService employeeService;
	private Employee emp;

		
	@BeforeClass	
    public static void initializer() {
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		employeeService=(EmployeeService)context.getBean("employeeService");
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		emp=null;
	}
	
    @Ignore
	@Test
	public void addEmployee() {
    	emp=new Employee();
		emp.setEmpId(225);
		emp.setName("DEVKHISHAN");
		emp.setDesignation("Executive Manager");
		emp.setSalary(40000);
		assertEquals(true,employeeService.addEmployee(emp));
	
	}
    
    @Ignore
    @Test  
    public void listEmployee()
    {
    	List<Employee> listemployee=employeeService.getEmployeeList();
    	
    	assertNotNull("problem in listing employee:",employeeService.getEmployeeList());
        
    	
    	for (Employee emp:listemployee)
    	{
        	
    	System.out.println(emp.getEmpId()+":::" +emp.getName()+":::"+emp.getDesignation()+":::"+emp.getSalary());	
    	}
    }
    
    //@Ignore
    @Test
    public void updateEmployee()   
    {
       Employee emp =employeeService.getEmployee(113);
        emp.setSalary(50000);
    	assertEquals(true,employeeService.updateEmployee(emp));
    }
    
    @Ignore
    @Test
    public void deleteEmployee()
    {
    	int empId=335;
    	assertEquals(true,employeeService.deleteEmployee(empId));
    }
    
    

}

