package com.scout.project.dev.service;

import java.sql.ResultSet;
import java.util.List;

import com.scout.project.dev.entity.App;
import com.scout.project.dev.entity.LoginInfo;

public interface QueryService {
	List<App> getApps();

	Object runQuery(String queryStatement, LoginInfo loginInfo);

	String runUpdate(String[] queries, LoginInfo loginInfo);

}
