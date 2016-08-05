package com.chen.dao;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.chen.bean.Project;

public class UserDao 
{
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Project query(String projectId)
	{
		Project project = null;
		try
		{
			String sql = "select * from t_fw_um_project where id = "+projectId;
			String [] args = {projectId};
			Map map = jdbcTemplate.queryForMap(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return project;
	}
}
