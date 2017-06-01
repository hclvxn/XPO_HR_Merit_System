package com.xpo.dao;

import java.util.List;

import com.xpo.model.EmployeeMeritDetails;
import com.xpo.model.StageWindow;

public interface EmpMeritDetailsDao {
	
	public List<EmployeeMeritDetails> getEmpMeritDetails(String empId);
	
	public void saveEmpMeritDetails(List<EmployeeMeritDetails> list);
	
	public List<String> getDirectReportees(String empId);
	
	public StageWindow getStageWindow(String stage);
	
	public boolean checkJobStatus(String stage, String empId);

}
