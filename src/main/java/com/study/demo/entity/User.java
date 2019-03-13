package com.study.demo.entity;

public class User {

	private int id;
	private String name;
	private String city;
	private String birthday;
	public  int getId() {
		return id;
	}
	public void setId( int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	/** 
	* @Title:
	* @Description: 
	* @param id
	* @param name
	* @param address
	*/
	public User(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	/** 
	* @Title:
	* @Description: 
	* @param id
	* @param name
	* @param city
	* @param birthday
	*/
	public User(int id, String name, String city, String birthday) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.birthday = birthday;
	}
	/** 
	* @Title:
	* @Description: 
	* @param name
	* @param city
	*/
	public User(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
