package com.bank.web.daoImpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.bank.web.daos.MemberDAO;
import com.bank.web.domain.CustomerBean;
import com.bank.web.domain.EmployeeBean;
import com.bank.web.pool.Constants;

public class MemberDAOImpl implements MemberDAO{
	
	@Override
	public void insertCustomer(CustomerBean param) {
		try {
			File file = new File(Constants.FILE_PATH+"customers.txt");
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(String.format("%s,%s,%s,%s,%s", param.getId(),param.getPw(),param.getName(),param.getSsn(),param.getCredit()));
			writer.newLine();
			writer.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertEmployee(EmployeeBean param) {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CustomerBean login(CustomerBean param) {
		try {
			File file = new File(Constants.FILE_PATH+"customers.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String msg = reader.readLine();
			reader.close();
			String[] customerInfo = new String[5];
			customerInfo = msg.split(",");
			param.setId(customerInfo[0]);
			param.setPw(customerInfo[1]);
			param.setName(customerInfo[2]);
			param.setSsn(customerInfo[3]);
			param.setCredit(customerInfo[4]);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return param;
	}

}
