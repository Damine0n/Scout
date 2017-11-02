package com.scout.project.dev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="app_node")
public class AppNode {
	
	@Id
	@Column(name="app_node_id")
	private int app_Node_ID;
	
	@Column(name="app_id")
	private int app_ID;
	
	@Column(name="node_name")
	private String node_Name;

	@Column(name="server_name")
	private String server_Name;

	@Column(name="active_passive")
	private String active_Passive;

	@Column(name="server_login")
	private String server_Login;

	@Column(name="server_password")
	private String server_Password;

	@Column(name="app_home_path")
	private String app_Home_Path;

	@Column(name="container")
	private String container;

	@Column(name="app_url")
	private String app_URL;

	@Column(name="app_webservice_url")
	private String app_Webservice_URL;

	@Column(name="db_hostname")
	private String db_Hostname;

	@Column(name="db_service_name")
	private String db_Service_Name;

	@Column(name="db_port")
	private int db_Port;

	@Column(name="db_login")
	private String db_Login;

	@Column(name="db_password")
	private String db_Password;

	public AppNode() {
		// TODO Auto-generated constructor stub
	}

	public int getApp_Node_ID() {
		return app_Node_ID;
	}

	public void setApp_Node_ID(int app_Node_ID) {
		this.app_Node_ID = app_Node_ID;
	}

	public int getApp_ID() {
		return app_ID;
	}

	public void setApp_ID(int app_ID) {
		this.app_ID = app_ID;
	}

	public String getNode_Name() {
		return node_Name;
	}

	public void setNode_Name(String node_Name) {
		this.node_Name = node_Name;
	}

	public String getServer_Name() {
		return server_Name;
	}

	public void setServer_Name(String server_Name) {
		this.server_Name = server_Name;
	}

	public String getActive_Passive() {
		return active_Passive;
	}

	public void setActive_Passive(String active_Passive) {
		this.active_Passive = active_Passive;
	}

	public String getServer_Login() {
		return server_Login;
	}

	public void setServer_Login(String server_Login) {
		this.server_Login = server_Login;
	}

	public String getServer_Password() {
		return server_Password;
	}

	public void setServer_Password(String server_Password) {
		this.server_Password = server_Password;
	}

	public String getApp_Home_Path() {
		return app_Home_Path;
	}

	public void setApp_Home_Path(String app_Home_Path) {
		this.app_Home_Path = app_Home_Path;
	}

	public String getContainer() {
		return container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public String getApp_URL() {
		return app_URL;
	}

	public void setApp_URL(String app_URL) {
		this.app_URL = app_URL;
	}

	public String getApp_Webservice_URL() {
		return app_Webservice_URL;
	}

	public void setApp_Webservice_URL(String app_Webservice_URL) {
		this.app_Webservice_URL = app_Webservice_URL;
	}

	public String getDb_Hostname() {
		return db_Hostname;
	}

	public void setDb_Hostname(String db_Hostname) {
		this.db_Hostname = db_Hostname;
	}

	public String getDb_Service_Name() {
		return db_Service_Name;
	}

	public void setDb_Service_Name(String db_Service_Name) {
		this.db_Service_Name = db_Service_Name;
	}

	public int getDb_Port() {
		return db_Port;
	}

	public void setDb_Port(int db_Port) {
		this.db_Port = db_Port;
	}

	public String getDb_Login() {
		return db_Login;
	}

	public void setDb_Login(String db_Login) {
		this.db_Login = db_Login;
	}

	public String getDb_Password() {
		return db_Password;
	}

	public void setDb_Password(String db_Password) {
		this.db_Password = db_Password;
	}

}
