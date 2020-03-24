package com.briup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.service.impl.CustomerDaoImpl;
import com.briup.utils.Message;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"注册/登录"})
public class CustomerControllerJpa {
	
	@Autowired
	private CustomerDaoImpl customerDaoImpl;
	
	@PostMapping("/register")
	@ApiOperation("注册")
	public Message<String> register(String username,String password){
		return customerDaoImpl.register(username, password);
	}
	@PostMapping("/login")
	@ApiOperation("登录")
	public Message<String> login(String username,String password){
		return customerDaoImpl.login(username, password);
}
}