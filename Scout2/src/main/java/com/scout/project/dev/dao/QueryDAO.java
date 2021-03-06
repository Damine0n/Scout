package com.scout.project.dev.dao;

import java.sql.ResultSet;
import java.util.List;

import com.scout.project.dev.entity.LoginInfo;

public interface QueryDAO {

	Object runQuery(String queryStatement,LoginInfo loginInfo);

	String runUpdate(String[] queries,LoginInfo loginInfo);

}
