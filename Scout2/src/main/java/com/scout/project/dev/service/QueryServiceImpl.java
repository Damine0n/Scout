package com.scout.project.dev.service;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scout.project.dev.dao.QueryDAO;
import com.scout.project.dev.entity.App;
import com.scout.project.dev.entity.LoginInfo;


@Service
public class QueryServiceImpl implements QueryService {
	//Inject DAO
	@Autowired
	private QueryDAO queryDAO;
	
	@Override
	@Transactional
	public List<App> getApps(){
		return queryDAO.getApps();
	}

	@Override
	@Transactional
	public Object runQuery(String queryStatement,LoginInfo loginInfo) {
		
		return queryDAO.runQuery(queryStatement,loginInfo);
	}

	@Override
	@Transactional
	public String runUpdate(String[] queries,LoginInfo loginInfo) {

		return queryDAO.runUpdate(queries,loginInfo);
	}

}
