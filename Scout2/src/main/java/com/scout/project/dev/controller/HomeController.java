package com.scout.project.dev.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scout.project.dev.entity.LoginInfo;
import com.scout.project.dev.service.QueryService;

@Controller
public class HomeController {
	
	//inject the customer service
	@Autowired
	private QueryService queryService;
	
	private LoginInfo loginInfo;
	private String driver = "oracle.jdbc.OracleDriver";
//	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	@RequestMapping("/Home")
	public String showLogin(){
		return "MIF-login";
	}
	
	@PostMapping("/processLogin")
	public String mifLogin(
			@RequestParam("userName") String userName,
			@RequestParam("passWord") String password,
			@RequestParam("department") String department,
			Model model){

		loginInfo = new LoginInfo(userName,password,department);
		String jdbc2 = loginInfo.getURL();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to database: "+ jdbc2);
			//Connection connection = DriverManager.getConnection(jdbc2,userName,password);
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@fd-dcomsdev1.floordecor.com:1521/FAQMANH.floordecor.com",userName,password);
			connection.close();
			model.addAttribute("userName",userName);
			model.addAttribute("passWord",password);
			model.addAttribute("department",department);
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Didn't Work!!!");
			return "redirect:/";
		}
		 
		return "login-confirmation";
		
	}
	
	@PostMapping(value="/queryDatabase",params={"query"})
	public String mifQuery(@RequestParam("queryStatement") String queryStatement, Model model){
		System.out.println(queryStatement);
		Object resultSet = queryService.runQuery(queryStatement,loginInfo);
		if(resultSet instanceof String){
			model.addAttribute("error", true);
			model.addAttribute("errorStatement", resultSet.toString());
		}else if (resultSet instanceof ResultSet){
			List<Map<String, Object>> rows=null;
			try {	
				rows  = resultSetToList((ResultSet) resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			model.addAttribute("rows", rows);
		}
		return  "login-confirmation";
		
	}
	
	@PostMapping(value="/queryDatabase",params={"update"})
	public String mifUpdate(@RequestParam("queryStatement") String queryStatement, Model model){
		System.out.println(queryStatement);
		String [] queries =queryStatement.split(";");
		String hasUpdated = queryService.runUpdate(queries,loginInfo);
		if(!hasUpdated.trim().equals("")){
			model.addAttribute("error", true);
			model.addAttribute("errorStatement", hasUpdated);
		}else{
			model.addAttribute("error", true);
			model.addAttribute("errorStatement", "SQL Update Successful!");
		}
		System.out.println(hasUpdated);
		return  "login-confirmation";
	}
	
	public List<Map<String, Object>> resultSetToList( ResultSet resultSet) throws SQLException{
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int columnCount = metaData.getColumnCount();

		while (resultSet.next()) {
		    Map<String, Object> columns = new LinkedHashMap<String, Object>();

		    for (int i = 1; i <= columnCount; i++) {
		        columns.put(metaData.getColumnLabel(i), resultSet.getObject(i));
		    }

		    rows.add(columns);
		}

		return rows;
	}

}
