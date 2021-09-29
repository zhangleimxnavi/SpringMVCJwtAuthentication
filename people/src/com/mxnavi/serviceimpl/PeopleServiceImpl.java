package com.mxnavi.serviceimpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mxnavi.pojo.People;
import com.mxnavi.service.PeopleService;

public class PeopleServiceImpl implements PeopleService{

	@Override
	public List<People> showAll() throws IOException {
		// TODO Auto-generated method stub
		
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory  sf =  new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sf.openSession();
		List<People> list = session.selectList("com.mxnavi.mapper.PeopleMapper.selectAll");
		
		return list;
	}

	
}
