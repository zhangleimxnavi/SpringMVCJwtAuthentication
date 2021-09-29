package com.mxnavi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.mxnavi.pojo.Role;

public interface RoleMapper {
	
	@Select("select * from role where id in (select rid from user_role where uid = #{id})")
	public List<Role> selRoleListByID(int id);
	
}

