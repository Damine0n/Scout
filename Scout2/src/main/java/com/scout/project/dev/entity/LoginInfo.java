package com.scout.project.dev.entity;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;


public class LoginInfo {

	String userName;
	
	String password;
	
	String department;
	
	String URL;
	
	private String driver = "oracle.jdbc.OracleDriver";
	
	Map <String,String> departments = new HashMap<String, String>();

	public LoginInfo() {
		// TODO Auto-generated constructor stub
	}

	public LoginInfo(String userName, String password, String department) {
		super();
		this.userName = userName;
		this.password = password;
		this.department = department;
		
		departments.put("QA/DEV", "jdbc:oracle:thin:@fd-dcomsdev1.floordecor.com:1521:FAQMANH.floordecor.com");
		departments.put("PROD", "jdbc:oracle:thin:@FAPMANH-SCAN.floordecor.com:1521/FAPMANH.floordecor.com");

		setURL(department);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getURL(){
		return URL;
	}
	
	public void setURL(String department){
		URL = departments.get(department);
		System.out.println("URL is =========" + URL);
	}
	
	@Bean
    public DataSource dataSource()
    {
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(getURL());
        dataSource.setUsername(getUserName());
        dataSource.setPassword(getPassword());
        return dataSource;
    }
 


}
