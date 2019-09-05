package com.bank.web.serviceImples;

import java.util.ArrayList;
import java.util.List;

import com.bank.web.daoImpls.MemberDAOImpl;
import com.bank.web.daos.MemberDAO;
import com.bank.web.domain.CustomerBean;
import com.bank.web.domain.EmployeeBean;
import com.bank.web.domain.MemberBean;
import com.bank.web.pool.Constants;
import com.bank.web.services.MemberService;

public class MemberServiceImpl implements MemberService {
	//private List<CustomerBean> customers;
	private List<EmployeeBean> employees;
	private CustomerBean customer;
	private MemberDAO dao;
	
	public MemberServiceImpl() {
	//	customers = new ArrayList<>();
		employees = new ArrayList<>();
		customer = new CustomerBean();
		dao = new MemberDAOImpl();
	}
	@Override
	public void join(CustomerBean param) {
		dao.insertCustomer(param);
	}

	@Override
	public void resister(EmployeeBean param) {
		employees.add(param);
		
	}
/*
	@Override
	public List<CustomerBean> findAllCustomers() {
		return customers;
	}

	@Override
	public List<EmployeeBean> findAllAdmins() {
		return employees;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> members = new ArrayList<>();
		int count = 0;
		for(CustomerBean c : customers) {
			if(name.equals(c.getName())) {
				count++;
			}
		}
		for(EmployeeBean e : employees) {
			if(name.equals(e.getName())) {
				count++;
				break;
			}
		}
		int a = 0;
		for(CustomerBean c : customers) {
			if(name.equals(c.getName())) {
				members.add(c);
				a++;
				if(count == a) {
					return members;
				}
			}
		}
		for(EmployeeBean e : employees) {
			if(name.equals(e.getName())) {
				members.add(e);
				a++;
				break;
			}
		}
		return members;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean m = new MemberBean();
		for(CustomerBean c : customers) {
			if(id.equals(c.getId())) {
				m = c;
				break;
			}
		}
		for(EmployeeBean e : employees) {
			if(id.equals(e.getId())) {
				m = e;
				break;
			}
		}
		
		return m;
	}
*/
	@Override
	public CustomerBean login(CustomerBean param) {
		return dao.login(param);
	}
/*
	@Override
	public int countMembers() {
		return customers.size();
	}

	@Override
	public int countAdmins() {
		return employees.size();
	}

	@Override
	public boolean existId(String id) {
		boolean flag = false;
		if(customers.contains(findById(id)) || employees.contains(findById(id))) {
			flag = true;
		}
		return flag;
	}

	@Override
	public void updatePass(MemberBean param) {
		MemberBean member = findById(param.getId());
		String oldPw = param.getPw().split(",")[0];
		String newPw = param.getPw().split(",")[1];
		if(oldPw.equals(member.getPw())) {
			member.setPw(newPw);
		}
	}

	@Override
	public boolean deleteMember(MemberBean param) {
		boolean flag = false;
		MemberBean member = findById(param.getId());
		if(param.getPw().equals(member.getPw())) {
			customers.remove(member);
			employees.remove(member);
			flag=true;
		}
		return flag;		
	}
*/
	

	
}