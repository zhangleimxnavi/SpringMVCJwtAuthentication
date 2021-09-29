package com.mxnavi.service;

import java.io.IOException;
import java.util.List;

import com.mxnavi.pojo.People;

public interface PeopleService {

	public List<People> showAll() throws IOException;
	
}
