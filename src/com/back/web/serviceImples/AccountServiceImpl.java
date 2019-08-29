package com.back.web.serviceImples;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.bank.web.domain.AccountBean;
import com.bank.web.services.AccountService;

public class AccountServiceImpl implements AccountService{
	private List<AccountBean> accounts;
	
	public AccountServiceImpl() {	
		accounts = new ArrayList<>();
	}
	
	@Override
	public void createAccount(int money) {
		AccountBean account = new AccountBean();
		account.setMoney(String.valueOf(money));
		account.setAccountNum(createAccountNum());
		account.setToday(findDate());
		accounts.add(account);
	}

	@Override
	public String createAccountNum() {
		Random ran = new Random();
		int first = ran.nextInt(9999);
		int twice = ran.nextInt(9999);
		String num = String.format("%4d - %4d", first,twice);
		return num;
	}

	@Override
	public List<AccountBean> findAll() {
		return accounts;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean account = new AccountBean();
		for(AccountBean a : accounts) {
			if(accountNum.equals(a.getAccountNum())) {
				account = a;
				break;
			}
		}
		return account;
	}

	@Override
	public int countAccounts() {
		return accounts.size();
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		boolean flag = true;
		for(AccountBean ac : accounts) {
			if(accountNum.equals(ac.getAccountNum())) {
				flag = false;
			}
		}
		return flag;
	}

	@Override
	public String findDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String today = sdf.format(date);
		return today;
	}

	@Override
	public void depositMoney(AccountBean param) {
		AccountBean account = findByAccountNum(param.getAccountNum());
		Double deposit = Double.parseDouble(account.getMoney())+Double.parseDouble(param.getMoney());
		account.setAccountNum(String.valueOf(deposit));
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		AccountBean account = findByAccountNum(param.getAccountNum());
		Double withdraw = Double.parseDouble(account.getMoney())-Double.parseDouble(param.getMoney());
		account.setAccountNum(String.valueOf(withdraw));
		
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		for(AccountBean ac : accounts) {
			if(accountNum.equals(ac.getAccountNum())) {
				accounts.remove(ac);
				break;
			}
		}
	}
	

}