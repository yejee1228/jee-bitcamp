package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domain.CustomerBean;
import com.bank.web.pool.Constants;
import com.bank.web.serviceImples.MemberServiceImpl;
import com.bank.web.services.MemberService;

public class LoginCommand extends MoveCommand{
	public LoginCommand(HttpServletRequest request) throws Exception{
		super(request);
	}
@Override 
	public void execute() {
		super.execute();
		CustomerBean customer = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("로그인서비스 진입"+ id+pw);
		if(id.equals(service.login(customer).getId())
				&&pw.equals(service.login(customer).getPw())) {
			service.login(customer);
			System.out.println("성공");
			request.setAttribute("customer", customer);
			Receiver.cmd.setPage("mypage");
		} else {
			Receiver.cmd.setView(String.format(Constants.VIEW_PATH,domain,"login"));
			System.out.println("실패"+Receiver.cmd.getPage());

		}
		
	}
}
