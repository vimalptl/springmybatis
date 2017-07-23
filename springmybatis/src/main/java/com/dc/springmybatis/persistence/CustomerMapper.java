package com.dc.springmybatis.persistence;

import com.dc.springmybatis.bo.Customer;

public interface CustomerMapper {
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
}
