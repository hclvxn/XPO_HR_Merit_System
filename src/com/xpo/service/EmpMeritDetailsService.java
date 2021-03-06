package com.xpo.service;

import java.util.List;

import com.xpo.bean.UserBean;
import com.xpo.model.EmployeeMeritDetails;

public interface EmpMeritDetailsService {
	
	public List<EmployeeMeritDetails> getEmpMeritDetails(String empId);
	
	public void saveEmpMeritDetails(List<EmployeeMeritDetails> list, UserBean user, String saveInd);
	
	public void submitEmpMeritDetails(List<EmployeeMeritDetails> list, UserBean user, String submitInd);
	
	public List<String> getDirectReportees(String empId);
	
	public boolean isStageCompleted(String stage, String empId);

}
