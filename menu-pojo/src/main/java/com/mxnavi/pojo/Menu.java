package com.mxnavi.pojo;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable{
	private int id;
	private String name;
	private int pid;
	private Menu parent;
	private List<Menu> childrens;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPid() {
		return pid;
	}



	public void setPid(int pid) {
		this.pid = pid;
	}



	public Menu getParent() {
		return parent;
	}



	public void setParent(Menu parent) {
		this.parent = parent;
	}



	public List<Menu> getChildrens() {
		return childrens;
	}



	public void setChildrens(List<Menu> childrens) {
		this.childrens = childrens;
	}



	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", pid=" + pid + ", parent=" + parent + ", childrens=" + childrens
				+ "]";
	}
	
	
	
	

}
