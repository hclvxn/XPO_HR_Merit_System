package com.xpo.service;

import java.util.List;

import com.xpo.model.EmployeeMeritDetails;

public interface EmpMeritDetailsService {
	
	public List<EmployeeMeritDetails> getEmpMeritDetails(String empId);

}
