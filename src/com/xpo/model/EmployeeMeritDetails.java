package com.xpo.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="employee_merit_details")
public class EmployeeMeritDetails implements Serializable {
	
	
	 private static final long serialVersionUID = -723583058586873478L;

	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "EmployeeId")
	 private String empId;
	 
	 @Column(name="FirstName")
	 private String firstName;
	 
	 @Column(name="LastName")
	 private String lastName;
	 
	 @Column(name="JobTitle")
	 private String jobTitle;
	 
	 @Column(name="HireDate")
	 private String hireDate;
	 
	 @Column(name="PerformanceSurvey")
	 private Float performanceSurvey;
	 
	 @Column(name="CurrentSalary")
	 private Float currentSalary;
	 
	 @Column(name="TargetAmount")
	 private Float targetSalary;
	 
	 @Column(name="TargetPercentage")
	 private Float targetPercentage;
	 
	 @Column(name="RecommendedSalPerc")
	 private Float recommendedSalPerc;
	 
	 @Column(name="RecommendedSalAmt")
	 private Float recommendedSalAmt;
	 
	 @Column(name="SalAfterMerit")
	 private Float salAfterMerit;
	 
	 @Column(name="LastSalaryHikeDate")
	 private String lastSalaryHikeDate;
	 
	 @Column(name="MeritCycle")
	 private String meritCycle;
	 
	 @Column(name="Type")
	 private String type;
	 
	 
	 @Column(name="DirectManager")
	 private String directManager;
	 
	 @Column(name="L1Manager")
	 private String l1Manager;
	 
	 @Column(name="L2Manager")
	 private String l2Manager;
	 
	 @Column(name="L3Manager")
	 private String l3Manager;
	 
	 @Column(name="MeritSystem")
	 private String meritSystem;
	 
	 @Column(name="Organization")
	 private String organization;
	 
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public Float getPerformanceSurvey() {
		return performanceSurvey;
	}

	public void setPerformanceSurvey(Float performanceSurvey) {
		this.performanceSurvey = performanceSurvey;
	}

	public Float getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(Float currentSalary) {
		this.currentSalary = currentSalary;
	}

	public Float getTargetSalary() {
		return targetSalary;
	}

	public void setTargetSalary(Float targetSalary) {
		this.targetSalary = targetSalary;
	}

	public Float getTargetPercentage() {
		return targetPercentage;
	}

	public void setTargetPercentage(Float targetPercentage) {
		this.targetPercentage = targetPercentage;
	}

	public Float getRecommendedSalPerc() {
		return recommendedSalPerc;
	}

	public void setRecommendedSalPerc(Float recommendedSalPerc) {
		this.recommendedSalPerc = recommendedSalPerc;
	}

	public Float getRecommendedSalAmt() {
		return recommendedSalAmt;
	}

	public void setRecommendedSalAmt(Float recommendedSalAmt) {
		this.recommendedSalAmt = recommendedSalAmt;
	}

	public Float getSalAfterMerit() {
		return salAfterMerit;
	}

	public void setSalAfterMerit(Float salAfterMerit) {
		this.salAfterMerit = salAfterMerit;
	}

	public String getLastSalaryHikeDate() {
		return lastSalaryHikeDate;
	}

	public void setLastSalaryHikeDate(String lastSalaryHikeDate) {
		this.lastSalaryHikeDate = lastSalaryHikeDate;
	}

	public String getMeritCycle() {
		return meritCycle;
	}

	public void setMeritCycle(String meritCycle) {
		this.meritCycle = meritCycle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDirectManager() {
		return directManager;
	}

	public void setDirectManager(String directManager) {
		this.directManager = directManager;
	}

	public String getL1Manager() {
		return l1Manager;
	}

	public void setL1Manager(String l1Manager) {
		this.l1Manager = l1Manager;
	}

	public String getL2Manager() {
		return l2Manager;
	}

	public void setL2Manager(String l2Manager) {
		this.l2Manager = l2Manager;
	}

	public String getL3Manager() {
		return l3Manager;
	}

	public void setL3Manager(String l3Manager) {
		this.l3Manager = l3Manager;
	}

	public String getMeritSystem() {
		return meritSystem;
	}

	public void setMeritSystem(String meritSystem) {
		this.meritSystem = meritSystem;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	
}


