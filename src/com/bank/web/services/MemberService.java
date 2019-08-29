package com.bank.web.services;

import java.util.List;

import com.bank.web.domain.CustomerBean;
import com.bank.web.domain.EmployeeBean;
import com.bank.web.domain.MemberBean;

public interface MemberService {
	public void join(CustomerBean param);
	public void resister(EmployeeBean param);
	public List<CustomerBean> findAllCustomers();
	public List<EmployeeBean> findAllAdmins();
	public List<MemberBean> findByName(String name);
	public MemberBean findById(String id);
	public boolean login(MemberBean param);
	public int countMembers();
	public int countAdmins();
	public boolean existId(String id);
	public void updatePass(MemberBean param);
	public boolean deleteMember(MemberBean param);
}