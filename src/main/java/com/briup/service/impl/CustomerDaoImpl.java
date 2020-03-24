package com.briup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Customer;
import com.briup.dao.CustomerDao;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;
import com.briup.utils.StatusCodeUtil;
@Service
public class CustomerDaoImpl {
	@Autowired
	private CustomerDao customerDao;
	public Message<String> register(String username,String password){
		  username = username==null?"":username;
		  password = password==null?"":password;
		  if("".equals(username)||"".equals(password)) {
			  return MessageUtil.error(StatusCodeUtil.SAVEERROR_CODE, "用户名和密码不能为空");
		  }
		  //System.out.println("------------"+username);
		  Customer customer = customerDao.findByUsername(username);
		  if(customer!=null) {
			  return MessageUtil.error(StatusCodeUtil.SAVEERROR_CODE, "用户名已存在");
		  }else {
			  Customer customer2 = new Customer();
			  customer2.setUsername(username);
			  customer2.setPassword(password);
			  customerDao.save(customer2); 
		  }
		return MessageUtil.success();
	}
	
	public Message<String> login(String username,String password){
		  Customer customer = customerDao.findByUsername(username);
		 
		  if(customer!=null) {
			  	if(customer.getPassword().equals(password)) {
			  		return MessageUtil.success();
			  	}
			  return MessageUtil.error(StatusCodeUtil.SAVEERROR_CODE, "密码错误");
		  }else {
			  return MessageUtil.error(StatusCodeUtil.SAVEERROR_CODE, "用户名不存在");
		  }
		
	}
}
