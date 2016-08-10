package com.chen.service;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.chen.dao.UserDao;

public class UserService 
{
	//注入dao 否则无法使用事务
	private UserDao userDao;
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
	
	//@Test
	public void createUser()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		//System.out.println(userDao.queryMap("666"));
		System.out.println(userDao.queryChildren("3622d013-dadd-4d63-9930-4b7859f2e0d9"));
		
	}
	
	//@Test
	//@Transactional
	public void deletePermission()
	{
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//UserDao userDao = (UserDao) ctx.getBean("userDao");
		String permissionId = "'09073677-64e0-4932-85f1-65fe3137e108'";
		StringBuilder delPermissions = new StringBuilder();
		delPermissions.append(permissionId).append(",");
		List<Map<String,Object>> list = userDao.queryChildren(permissionId);
		
		while(list.size() > 0)
		{
			//每次查出来的children，作为下次查询的父类
			StringBuilder queryPermissions = new StringBuilder();
			//把权限id取出来
			for(Map<String,Object> m : list)
			{
				delPermissions.append("'").append(m.get("id")).append("',");
				queryPermissions.append("'").append(m.get("id")).append("',");
			}
			String queryPs = queryPermissions.toString();
			queryPs = queryPs.substring(0, queryPs.length()-1);
			list = userDao.queryChildren(queryPs);
		}
		String delPermission = delPermissions.toString();
		delPermission = delPermission.substring(0, delPermission.length()-1);
		p(delPermission);

		//p("删依赖关系="+userDao.deleteDependPermissions(delPermission));
		//p("删角色权限关联="+userDao.deleteRolePermissions(delPermission));
		//p("删权限="+userDao.deletePermissions(delPermission));
		p("删依赖关系="+userDao.deleteDependPermissions(delPermission));
		p("删权限="+userDao.deletePermissions(delPermission));
	}
	public void p(Object o)
	{
		System.out.println(o);
	}

}
