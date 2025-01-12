package com.restapi.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entity.employeeEntity;
import com.restapi.service.employeeService;

@RestController
public class employeeController {

	@Autowired
	employeeService service;
	
	@PostMapping("/employee")
	public String saveData(@RequestBody employeeEntity entity) throws ClassNotFoundException, SQLException {
	  return service.saveEmplyoee(entity);
	}
	
	@GetMapping("/employee")
	public List<employeeEntity> get() throws ClassNotFoundException, SQLException {
		return service.getData();
	}
	
	@DeleteMapping("/employee/{id}")
	public String delte(@PathVariable int id) throws ClassNotFoundException, SQLException {
		return service.deleteDATA(id);
	}
	
	@PatchMapping("/employee/{id}")
	public String update(@PathVariable int id,@RequestBody employeeEntity entity) throws ClassNotFoundException, SQLException {
		return service.updateem(id, entity);
	}
}
