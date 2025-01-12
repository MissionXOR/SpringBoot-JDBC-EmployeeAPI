package com.restapi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.restapi.entity.employeeEntity;

@Repository
public class employeeRepository {

	public String insertEmplyoee(employeeEntity entity) throws ClassNotFoundException, SQLException {
		
		Connection connection=DBConnection.DBConnect();
		
		PreparedStatement pst=connection.prepareStatement("insert into employee value(?,?,?,?)");
		
		pst.setInt(1, entity.getId());
		pst.setString(2, entity.getName());
		pst.setString(3, entity.getDep());
		pst.setDouble(4, entity.getSalary());
		
		pst.executeUpdate();
		
		return "employee insert successfully";
		
	}
	
	public List<employeeEntity> getallEmployee() throws ClassNotFoundException, SQLException {
		
		Connection connection=DBConnection.DBConnect();
		
		List<employeeEntity>list=new ArrayList<employeeEntity>();
		
		PreparedStatement pst=connection.prepareStatement("select * from employee");
		
		ResultSet rSet= pst.executeQuery();
		
		while(rSet.next())
		{
			employeeEntity emp =new employeeEntity(
					rSet.getInt("id"),
					
					rSet.getString("name"),
					
					rSet.getString("dep"),
					rSet.getDouble("salary")
					);
			
			list.add(emp);
		}
		
		return list;
	}
	
	public String deleteEmployee(int id) throws ClassNotFoundException, SQLException {
		Connection connection=DBConnection.DBConnect();
		
		PreparedStatement pst=connection.prepareStatement("delete from employee where id=?");
		
		pst.setInt(1, id);
		pst.executeUpdate();
		
		return "Delete successfully";
	}
	
	public String updateEmployee(int id,employeeEntity entity) throws ClassNotFoundException, SQLException 
	{
		Connection connection=DBConnection.DBConnect();
		
		PreparedStatement pst=connection.prepareStatement("update employee set name=?, dep=?, salary=? where id=?");
		
		pst.setString(1, entity.getName());
		pst.setString(2, entity.getDep());
		pst.setDouble(3, entity.getSalary());
		pst.setInt(4, id);
		
		int row=pst.executeUpdate();
		if(row>0)
		{
			return "update successful";
			
		}else {
			return "employee not found";
		}
	}
	
}
