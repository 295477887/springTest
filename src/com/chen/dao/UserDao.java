package com.chen.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao 
{
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Map queryMap(String projectId)
	{
		Map map = null;
		try
		{
			String sql = "select * from t_fw_um_project where id = "+projectId;
			String [] args = {projectId};
			map = jdbcTemplate.queryForMap(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	
	public List queryList()
	{
		List list = null;
		try
		{
			String sql = "select * from t_fw_um_project";
			list = jdbcTemplate.queryForList(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Map<String,Object>> queryChildren(String permissionId)
	{
		List<Map<String, Object>> list = null;
		try
		{
			String sql = "select * from t_fw_um_permission t where t.project_id = '111' and t.parent_id in ( " + permissionId +" )";
			list = jdbcTemplate.queryForList(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	//删权限依赖
	public int deleteDependPermissions(String permissionIds)
	{
		int result = 0;
		try
		{
			String sql = "delete from t_fw_um_permission_depend where c_id in ( " + permissionIds +" ) or d_id in ( " + permissionIds +" )";
			result = jdbcTemplate.update(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	
	//删权限角色关联表
	public int deleteRolePermissions(String permissionIds)
	{
		int result = 0;
		try
		{
			String sql = "delete from t_fw_um_role_permission_map where PERMISSION_ID in ( " + permissionIds +" )";
			result = jdbcTemplate.update(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	
	//删权限
	public int deletePermissions(String permissionIds)
	{
		int result = 0;
		try
		{
			String sql = "delete from t_fw_um_permission where id in ( " + permissionIds +" )";
			int i = 1/0;
			result = jdbcTemplate.update(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return result;
	}
}
