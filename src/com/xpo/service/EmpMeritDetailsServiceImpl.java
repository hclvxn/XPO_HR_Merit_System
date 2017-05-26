package com.xpo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xpo.dao.EmpMeritDetailsDao;
import com.xpo.model.EmployeeMeritDetails;


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

}
