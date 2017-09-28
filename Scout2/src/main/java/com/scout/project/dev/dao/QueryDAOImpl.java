package com.scout.project.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.scout.project.dev.entity.LoginInfo;

@Repository
public class QueryDAOImpl implements QueryDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private String driver = "oracle.jdbc.OracleDriver";
		
	@Override
	public Object runQuery(String queryStatement,LoginInfo loginInfo) {

		String user = loginInfo.getUserName();
		String pass = loginInfo.getPassword();
		String jdbcURL = loginInfo.getURL();
		
		ResultSet resultSet = null;
		try{
						
			Class.forName(driver);
			
			Connection myConnection = DriverManager.getConnection(jdbcURL,user,pass);
			
			resultSet = myConnection.createStatement().executeQuery(queryStatement);
			
			//myConnection.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		return resultSet;
	}

	@Override
	public String runUpdate(String[] queries,LoginInfo loginInfo) {
		String user = loginInfo.getUserName();
		String pass = loginInfo.getPassword();
		String jdbcURL = loginInfo.getURL();
		
		String hasUpdated="";
		for(String queryStatement : queries){
			try{		
				Class.forName(driver);
				
				Connection myConnection = DriverManager.getConnection(jdbcURL,user,pass);
				
				int error = myConnection.createStatement().executeUpdate(queryStatement);
				if(error==0){
					hasUpdated += "SQL Statement: "+queryStatement+"\n\twas unsuccessful.";
				}
				myConnection.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println(e.getMessage());
				hasUpdated += "SQL Error for statement: "+queryStatement+"\n\t"+e.getMessage();
			}
		}
		return hasUpdated;
	}

}
