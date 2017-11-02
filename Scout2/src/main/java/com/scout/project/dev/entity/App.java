package com.scout.project.dev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="app")
public class App {
	
	@Id
	@Column(name="app_id")
	private int app_ID;
	
	@Column(name="app_name")
	private String app_Name;
	
	@Column(name="app_instance")
	private String app_Instance;
	
	@Column(name="app_version")
	private String app_Version;
	
	

	public App() {
		// TODO Auto-generated constructor stub
	}



	public int getApp_ID() {
		return app_ID;
	}



	public void setApp_ID(int app_ID) {
		this.app_ID = app_ID;
	}



	public String getApp_Name() {
		return app_Name;
	}



	public void setApp_Name(String app_Name) {
		this.app_Name = app_Name;
	}



	public String getApp_Instance() {
		return app_Instance;
	}



	public void setApp_Instance(String app_Instance) {
		this.app_Instance = app_Instance;
	}



	public String getApp_Version() {
		return app_Version;
	}



	public void setApp_Version(String app_Version) {
		this.app_Version = app_Version;
	}

}
