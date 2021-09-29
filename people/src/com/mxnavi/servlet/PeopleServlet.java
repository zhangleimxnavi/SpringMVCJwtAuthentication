package com.mxnavi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mxnavi.pojo.People;
import com.mxnavi.service.PeopleService;
import com.mxnavi.serviceimpl.PeopleServiceImpl;

@WebServlet("/abc/peopleShow")

public class PeopleServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
/*		super.service(arg0, arg1);*/
		
		
		PeopleService ps = new PeopleServiceImpl();
		try {
			List<People> lists = ps.showAll();
			for (People people : lists) {
				System.out.println(people);
			}
			
			request.setAttribute("list", lists);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	
	
	

}
