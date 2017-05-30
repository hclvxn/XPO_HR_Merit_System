package com.xpo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xpo.model.EmployeeMeritDetails;

@Repository("empMeritDetailsDao")
public class EmpMeritDetailsDaoImpl implements EmpMeritDetailsDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<EmployeeMeritDetails> getEmpMeritDetails(String empId) {
		
		
		
		ArrayList<String> reportees = 
				new  ArrayList<String>(Arrays.asList(getReportees(empId).split(",")));
		
		Query query = sessionFactory.getCurrentSession().createQuery("FROM EmployeeMeritDetails empMeritDetails WHERE empMeritDetails.empId IN (:ids)");
		query.setParameterList("ids", reportees);
		List<EmployeeMeritDetails> empMeritDetails = query.list();
		
		return empMeritDetails;
	
		
		
		
		
	}
	
	
	@Override
	public void saveEmpMeritDetails(List<EmployeeMeritDetails> list) {
		
		for(EmployeeMeritDetails empMeritDetails: list) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(empMeritDetails);
			session.getTransaction().commit();
			session.close();
			
			
		}	
		
	}
	
	
	private String getReportees(String empId) {
		
		ProcedureCall query = sessionFactory.getCurrentSession().createStoredProcedureCall("xpopoc.GetReportees");
		query.registerParameter("empId", String.class, ParameterMode.IN).bindValue(empId);
		query.registerParameter("reportees", String.class, ParameterMode.OUT);
		ProcedureOutputs procedureResult=query.getOutputs();
		String reportees= (String) procedureResult.getOutputParameterValue("reportees");
		return reportees;
		
	}


	
	
	

}
