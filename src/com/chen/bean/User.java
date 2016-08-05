package com.chen.bean;

public class User 
{
	private String name;
	private String sex;
	private int age;
	private String home;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", sex=" + sex + ", age=" + age + ", home=" + home + "]";
	}
	

}
