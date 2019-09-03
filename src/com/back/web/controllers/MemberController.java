package com.back.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.web.serviceImples.MemberServiceImpl;
import com.bank.web.domain.CustomerBean;
import com.bank.web.services.MemberService;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		String credit = request.getParameter("credit");
		CustomerBean customer = new CustomerBean();
		customer.setCredit(credit);
		customer.setId(id);
		customer.setName(name);
		customer.setPw(pw);
		customer.setSsn(ssn);
		MemberService service = new MemberServiceImpl();
		service.join(customer);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
