package com.xpo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xpo.dao.EmpMeritDetailsDao;
import com.xpo.model.EmployeeMeritDetails;
import com.xpo.model.StageWindow;


@Service("empMeritDetailsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmpMeritDetailsServiceImpl implements EmpMeritDetailsService {
	
	@Autowired
	private EmpMeritDetailsDao empDao;

	@Override
	public List<EmployeeMeritDetails> getEmpMeritDetails(String empId) {
		// TODO Auto-generated method stub
		return empDao.getEmpMeritDetails(empId);
	}

	@Override
	public void saveEmpMeritDetails(List<EmployeeMeritDetails> list) {
		
		empDao.saveEmpMeritDetails(list);
		
	}

	@Override
	public List<String> getDirectReportees(String empId) {
		
		return empDao.getDirectReportees(empId);


	}

	@Override
	public boolean isStageCompleted(String stage, String empId) {
		
		LocalDate currentDate = LocalDate.now();
		StageWindow stageWindow = empDao.getStageWindow(stage);
		LocalDate startDate = stageWindow.getStartDate().toLocalDate();
		LocalDate endDate = stageWindow.getEndDate().toLocalDate();
		
		if(!(currentDate.isBefore(startDate) || currentDate.isAfter(endDate))) {
			
			if(stage.equals("Appraiser")) {
				
				if(empDao.checkJobStatus(stage, empId)){
					return true;
				}
				else {
					return false;
				}
				
				
			}
			else if(stage.equals("Reviewer")) {
				if(empDao.checkJobStatus(stage, empId)){
					return true;
				}
				else {
					return false;
				}
				
			}
			
		}
		
		
		return false;
		
		
		
		
	}
	
	
	

}
