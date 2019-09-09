package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	public MoveCommand(HttpServletRequest request) throws Exception{
		setRequest(request);
		setDomain(domain);
		setAction((request.getParameter("action")==null)?"move":request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		System.out.println("moveCommand의  execute"+request.getParameter("page"));
		super.execute();
		request.setAttribute("page", page);
	}
}
