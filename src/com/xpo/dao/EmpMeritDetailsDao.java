package com.xpo.dao;

import java.util.List;

import com.xpo.model.EmployeeMeritDetails;

public interface EmpMeritDetailsDao {
	
	public List<EmployeeMeritDetails> getEmpMeritDetails(String empId);
	
	public void saveEmpMeritDetails(List<EmployeeMeritDetails> list);

}
