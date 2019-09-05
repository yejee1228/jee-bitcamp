package com.bank.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.daoImpls.MemberDAOImpl;
import com.bank.web.daos.MemberDAO;
import com.bank.web.domain.CustomerBean;
import com.bank.web.pool.Constants;
import com.bank.web.serviceImples.MemberServiceImpl;
import com.bank.web.services.MemberService;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		CustomerBean customer = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		String action = request.getParameter("action");
		switch(action) {
		case "move" :
			request.getRequestDispatcher
			(String.format(Constants.VIEW_PATH,
					request.getParameter("folder"),request.getParameter("dest")))
			.forward(request, response);
			break;
		case "join" :
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String ssn = request.getParameter("ssn");
			String credit = request.getParameter("credit");
			customer.setCredit(credit);
			customer.setId(id);
			customer.setName(name);
			customer.setPw(pw);
			customer.setSsn(ssn);
			service.join(customer);
			System.out.println(id);
			request.getRequestDispatcher
			(String.format(Constants.VIEW_PATH,
					request.getParameter("folder"),request.getParameter("dest")))
			.forward(request, response);
			break;
		case "login" :
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			System.out.println("로그인서비스 진입"+ id+pw);
			if(id.equals(service.login(customer).getId())
					&&pw.equals(service.login(customer).getPw())) {
				service.login(customer);
				request.setAttribute("customer", customer);
				request.getRequestDispatcher
				(String.format(Constants.VIEW_PATH,
						request.getParameter("folder"),request.getParameter("dest")))
				.forward(request, response);
			} else {
				request.getRequestDispatcher
				(String.format(Constants.VIEW_PATH,
						request.getParameter("folder"),"login"))
				.forward(request, response);
			}
			
			break;
		case "existId" :
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
