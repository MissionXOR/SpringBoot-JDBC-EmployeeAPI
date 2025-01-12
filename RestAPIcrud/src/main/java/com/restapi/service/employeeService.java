package com.restapi.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entity.employeeEntity;
import com.restapi.repository.employeeRepository;

@Service
public class employeeService {

	@Autowired
	employeeRepository repository;
	
	public String saveEmplyoee(employeeEntity entity) throws ClassNotFoundException, SQLException {
		return repository.insertEmplyoee(entity);
	}
	
	public List<employeeEntity> getData() throws ClassNotFoundException, SQLException {
		
	return	repository.getallEmployee();
	}
	
	public String deleteDATA(int id) throws ClassNotFoundException, SQLException {
		return repository.deleteEmployee(id);
	}
	
	public String updateem(int id,employeeEntity entity) throws ClassNotFoundException, SQLException {
		
		return repository.updateEmployee(id, entity);
	}
}
