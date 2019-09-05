package com.bank.web.daos;

import com.bank.web.domain.CustomerBean;
import com.bank.web.domain.EmployeeBean;

public interface MemberDAO {
	public void insertCustomer(CustomerBean param);
	public void insertEmployee(EmployeeBean param);
	public CustomerBean login(CustomerBean param);
}
