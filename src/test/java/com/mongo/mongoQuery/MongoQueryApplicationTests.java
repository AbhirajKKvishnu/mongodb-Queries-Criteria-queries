package com.mongo.mongoQuery;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.mongo.controller.EmployeeController;
import com.mongo.entity.Employee;

@SpringBootTest
class MongoQueryApplicationTests {
	
	@MockBean
    private EmployeeController employeeController;
	
//	@MockBean
//	MongoOperations mongoOperations;
	


	 @Test
	    public void testSaveEmployee() {
	        Employee employee = new Employee();
	        employee.setId("1");
	        employee.setName("John Doe");
	        employee.setDepartment("Engineering");
	        employee.setAge(30);

	        Mockito.when(employeeController.saveAll(Mockito.any(Employee.class))).thenReturn(employee);

	        Employee savedEmployee = employeeController.saveAll(employee);

	        assertEquals("1", savedEmployee.getId());
	        assertEquals("John Doe", savedEmployee.getName());
	        assertEquals("Engineering", savedEmployee.getDepartment());
	        assertEquals(30, savedEmployee.getAge());
	    }

}
