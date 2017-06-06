package com.xpo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xpo.bean.UserBean;
import com.xpo.model.EmployeeMeritDetails;
import com.xpo.model.JobStatus;
import com.xpo.model.JobStatusPK;
import com.xpo.model.StageWindow;

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
	public void saveEmpMeritDetails(List<EmployeeMeritDetails> list, UserBean user, String saveInd) {
		
		Session session = null;
		
		Long cntOfStatus = 0L;
		Long cntOfIndirectRep = 0L;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		for(EmployeeMeritDetails empMeritDetails: list) {
			
			session.saveOrUpdate(empMeritDetails);
			
			
			
		}	
		
		if(saveInd.equals("saveDirect")) {
			
			Query query = sessionFactory.getCurrentSession().createSQLQuery("select count(*) as count from xpopoc.job_status js where js.EmployeeId = :empId and "
					+ "js.Level = :level")
					.addScalar("count", LongType.INSTANCE);
			query.setParameter("empId", user.getUserName());
			query.setParameter("level", "Appraiser");
			cntOfStatus = (Long)query.uniqueResult();
			
			query = sessionFactory.getCurrentSession().createSQLQuery("select count(*) as count from xpopoc.user_hierarchy uh where uh.DirectManagerId in (:directReportees)")
					.addScalar("count", LongType.INSTANCE);
			List<String> dirReportees = getDirectReportees(user.getUserName());
			query.setParameterList("directReportees", dirReportees);
			cntOfIndirectRep = (Long)query.uniqueResult();
			
			if(cntOfStatus < 1) {
				
				
				
				
				JobStatus jobStatus = new JobStatus();
				JobStatusPK jobStatusPK = new JobStatusPK();
				jobStatusPK.setEmployeeId(user.getUserName());
				jobStatusPK.setLevel("Appraiser");
				jobStatus.setJobStatusPK(jobStatusPK);
				jobStatus.setStatus("Pending");
				session.save(jobStatus);
				
				if(cntOfIndirectRep < 1) {
					
					jobStatus = new JobStatus();
					jobStatusPK = new JobStatusPK();
					jobStatusPK.setEmployeeId(user.getUserName());
					jobStatusPK.setLevel("Reviewer");
					jobStatus.setJobStatusPK(jobStatusPK);
					jobStatus.setStatus("Pending");
					session.save(jobStatus);
					
				}
			}
			
		}
		
		else if(saveInd.equals("saveIndirect")) {
			
			Query query = sessionFactory.getCurrentSession().createSQLQuery("select count(*) as count from xpopoc.job_status js where "
					+ "js.EmployeeId = :empId and js.Level = :level")
					.addScalar("count", LongType.INSTANCE);
			query.setParameter("empId", user.getUserName());
			query.setParameter("level", "Reviewer");
			cntOfStatus = (Long)query.uniqueResult();
			
			if(cntOfStatus < 1) {
				
					
				JobStatus jobStatus = new JobStatus();
				JobStatusPK jobStatusPK = new JobStatusPK();
				jobStatusPK.setEmployeeId(user.getUserName());
				jobStatusPK.setLevel("Reviewer");
				jobStatus.setJobStatusPK(jobStatusPK);
				jobStatus.setStatus("Pending");
				session.save(jobStatus);
				
			}
			
			
		}
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Override
	public void submitEmpMeritDetails(List<EmployeeMeritDetails> list, UserBean user, String submitInd) {
		
		Session session = null;
		String updateQuery;
		
		Long cntOfStatus = 0L;
		Long cntOfIndirectRep = 0L;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		for(EmployeeMeritDetails empMeritDetails: list) {
			session.saveOrUpdate(empMeritDetails);
			
			
		}
		
		if(submitInd.equals("submitDirect")) {
			
			Query query = sessionFactory.getCurrentSession().createSQLQuery("select count(*) as count from xpopoc.job_status js where js.EmployeeId = :empId and js.Level = :level")
					.addScalar("count", LongType.INSTANCE);
			query.setParameter("empId", user.getUserName());
			query.setParameter("level", "Appraiser");
			cntOfStatus = (Long)query.uniqueResult();
			
			query = sessionFactory.getCurrentSession().createSQLQuery("select count(*) as count from xpopoc.user_hierarchy uh where uh.DirectManagerId in (:directReportees)")
					.addScalar("count", LongType.INSTANCE);
			List<String> dirReportees = getDirectReportees(user.getUserName());
			query.setParameterList("directReportees", dirReportees);
			cntOfIndirectRep = (Long)query.uniqueResult();
			
			if(cntOfStatus > 0) {
				
				
				
				JobStatus jobStatus = new JobStatus();
				JobStatusPK jobStatusPK = new JobStatusPK();
				jobStatusPK.setEmployeeId(user.getUserName());
				jobStatusPK.setLevel("Appraiser");
				jobStatus.setJobStatusPK(jobStatusPK);
				jobStatus.setStatus("Completed");
				session.update(jobStatus);
				
				if(cntOfIndirectRep < 1) {
					
					jobStatus = new JobStatus();
					jobStatusPK = new JobStatusPK();
					jobStatusPK.setEmployeeId(user.getUserName());
					jobStatusPK.setLevel("Reviewer");
					jobStatus.setJobStatusPK(jobStatusPK);
					jobStatus.setStatus("Completed");
					session.update(jobStatus);
					
				}
					
					
					
				
			}
			else {
				JobStatus jobStatus = new JobStatus();
				JobStatusPK jobStatusPK = new JobStatusPK();
				jobStatusPK.setEmployeeId(user.getUserName());
				jobStatusPK.setLevel("Appraiser");
				jobStatus.setJobStatusPK(jobStatusPK);
				jobStatus.setStatus("Completed");
				session.save(jobStatus);
				
				if(cntOfIndirectRep < 1) {
					
					jobStatus = new JobStatus();
					jobStatusPK = new JobStatusPK();
					jobStatusPK.setEmployeeId(user.getUserName());
					jobStatusPK.setLevel("Reviewer");
					jobStatus.setJobStatusPK(jobStatusPK);
					jobStatus.setStatus("Completed");
					session.save(jobStatus);
					
				}
			}
			
		}
		
		else if(submitInd.equals("submitIndirect")) {
			
			Query query = sessionFactory.getCurrentSession().createSQLQuery("select count(*) as count from xpopoc.job_status js where js.EmployeeId = :empId "
					+ "and js.Level = :level")
					.addScalar("count", LongType.INSTANCE);
			query.setParameter("empId", user.getUserName());
			query.setParameter("level", "Reviewer");
			cntOfStatus = (Long)query.uniqueResult();
			
			if(cntOfStatus > 0) {
				
				JobStatus jobStatus = new JobStatus();
				JobStatusPK jobStatusPK = new JobStatusPK();
				jobStatusPK.setEmployeeId(user.getUserName());
				jobStatusPK.setLevel("Reviewer");
				jobStatus.setJobStatusPK(jobStatusPK);
				jobStatus.setStatus("Completed");
				session.update(jobStatus);
			}
			else {
				
				JobStatus jobStatus = new JobStatus();
				JobStatusPK jobStatusPK = new JobStatusPK();
				jobStatusPK.setEmployeeId(user.getUserName());
				jobStatusPK.setLevel("Reviewer");
				jobStatus.setJobStatusPK(jobStatusPK);
				jobStatus.setStatus("Completed");
				session.save(jobStatus);
				
			}
			
			
		}
		
		session.getTransaction().commit();
		session.close();
	}
			
	
	
	private String getReportees(String empId) {
		
		ProcedureCall query = sessionFactory.getCurrentSession().createStoredProcedureCall("xpopoc.GetReportees");
		query.registerParameter("empId", String.class, ParameterMode.IN).bindValue(empId);
		query.registerParameter("reportees", String.class, ParameterMode.OUT);
		ProcedureOutputs procedureResult=query.getOutputs();
		String reportees= (String) procedureResult.getOutputParameterValue("reportees");
		return reportees;
		
	}
	
    public List<String> getIndirectReporteesCount(String empId) {
		
		ProcedureCall query = sessionFactory.getCurrentSession().createStoredProcedureCall("xpopoc.GetIndirectReportees");
		query.registerParameter("empId", String.class, ParameterMode.IN).bindValue(empId);
		query.registerParameter("reportees", String.class, ParameterMode.OUT);
		ProcedureOutputs procedureResult=query.getOutputs();
		String reportees= (String) procedureResult.getOutputParameterValue("reportees");
		ArrayList<String> reporteesList = 
				new  ArrayList<String>(Arrays.asList(reportees.split(",")));
		
		return reporteesList;
		
	}
	
    
    public List<String> getDirectReportees(String empId) {
    	
    	Query query = sessionFactory.getCurrentSession().createSQLQuery("select u.EmployeeID from xpopoc.user_hierarchy u where u.DirectManagerId = :empId").
    			setParameter("empId", empId);
    	List<String> result = query.list();
    	
    	    	
		return result;
    	
    	
    }


	@Override
	public StageWindow getStageWindow(String stage) {
		
		StageWindow stageWindow = (StageWindow) sessionFactory.getCurrentSession().get(StageWindow.class, stage);
			
		return stageWindow;
	}


	@Override
	public boolean checkJobStatus(String stage, String empId) {
		
		if(stage.equals("Reviewer")) {
			
			Query query = sessionFactory.getCurrentSession().createSQLQuery("select count(*) as count from xpopoc.job_status js where js.EmployeeId in (:empId) and "
					+ "js.level = :stage and status = :status").addScalar("count", LongType.INSTANCE);
			List<String> dirReportees = getDirectReportees(empId);
			query.setParameter("empId", dirReportees);
			query.setParameter("stage", stage);
			query.setParameter("status", "Completed");
			if((Long)query.uniqueResult() == dirReportees.size())
				return true;
			else
				return false;

					
		}
		else if(stage.equals("Appraiser")) {
			Query query = sessionFactory.getCurrentSession().createSQLQuery("select count(*) as count from xpopoc.job_status js where js.EmployeeId  = :empId and "
					+ "js.level = :stage and status = :status").addScalar("count", LongType.INSTANCE);
			query.setParameter("empId", empId);
			query.setParameter("stage", stage);
			query.setParameter("status", "Completed");
			
			if((Long)query.uniqueResult() == 1)
				return false;
			else
				return true;
			
		}
		else
			return false;
		
	}
	


	
	
	

}
