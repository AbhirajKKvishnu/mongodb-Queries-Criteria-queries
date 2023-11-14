package com.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.dto.EmployeeDTO;
import com.mongo.entity.Employee;

@RestController
@RequestMapping(value = "/check")
public class EmployeeController {

	@Autowired
	private MongoOperations mongoOperations;

	@PostMapping(value = "/employees")
	public
	Employee saveAll(@RequestBody Employee employee) {
		return mongoOperations.insert(employee);
	}

	@GetMapping(value = "/employees/{name}")
	public ResponseEntity<EmployeeDTO> getCustomer(@PathVariable String name) {
		Employee employee =new Employee();
		EmployeeDTO dto = new EmployeeDTO();
		Query query = new Query();
		Criteria criteria = new Criteria();
		addCriteria(criteria, "name", name);
		query.addCriteria(criteria);
		employee=mongoOperations.findOne(query, Employee.class);
		dto.setId(employee.getId());
		dto.setName(employee.getName());
		dto.setAge(employee.getAge());
		dto.setDepartment(employee.getDepartment());
		return new ResponseEntity<>(dto, HttpStatus.OK);

	}

	private void addCriteria(Criteria criteria, String querykey, String queryname) {
		criteria.and(querykey).is((String) queryname);
	}

}
