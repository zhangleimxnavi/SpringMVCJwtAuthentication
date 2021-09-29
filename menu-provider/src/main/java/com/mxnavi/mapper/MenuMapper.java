package com.mxnavi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mxnavi.pojo.Menu;

public interface MenuMapper {
	
	public List<Menu> selAll();
	
	public Menu selById(int id);
	
	public List<Menu> selByPid(int pid);
	
	public int updByIdAndName(Menu menu);
	
}
