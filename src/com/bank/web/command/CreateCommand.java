package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domain.CustomerBean;
import com.bank.web.serviceImples.MemberServiceImpl;
import com.bank.web.services.MemberService;

public class CreateCommand extends MoveCommand{

	public CreateCommand(HttpServletRequest request) throws Exception {
		super(request);
	}
	@Override
	public void execute() {
		super.execute();
		CustomerBean customer = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		
		customer.setCredit(request.getParameter("credit"));
		customer.setId(request.getParameter("id"));
		customer.setName(request.getParameter("name"));
		customer.setPw(request.getParameter("pw"));
		customer.setSsn(request.getParameter("ssn"));
		service.join(customer);
		Receiver.cmd.setPage("login");
		System.out.println(request.getParameter("id"));
	}
}
