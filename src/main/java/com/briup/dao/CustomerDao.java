package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{
	Customer findByUsername(String username);
	//Customer findByPassword(String password);
}
