package com.xpo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xpo.bean.EmpMeritDetailsBean;
import com.xpo.bean.EmpMeritDetailsListBean;
import com.xpo.bean.UserBean;
import com.xpo.model.EmployeeMeritDetails;
import com.xpo.service.EmpMeritDetailsService;


@Controller
@RequestMapping("/merit")
public class EmpMeritDetailsController {
	
	@Autowired
	private EmpMeritDetailsService empService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//binder.setDisallowedFields(new String[] {"password"});;
		//SimpleDateFormat df = new SimpleDateFormat("yyyy***mm***yy");
		//binder.registerCustomEditor(Date.class, "loginDate", new CustomDateEditor(df, false));
		//binder.registerCustomEditor(String.class, "userName", new UserNameEditor());
	}
	
	

	
	@ModelAttribute()
	public void setHeader(Model model, HttpServletRequest request) {
		
		if(request.getSession().getAttribute("userInfo")!= null || request.getSession().getAttribute("userInfo") != ""){
			
			
			model.addAttribute("user", (UserBean)request.getSession().getAttribute("userInfo"));
			
		}
		
		
		
	}
	
	@RequestMapping(value="/getEmpMeritDetails.html", method = RequestMethod.GET)
	public ModelAndView GetEmpMeritDetails(@Valid @ModelAttribute("user") UserBean user, 
			BindingResult result) {
		
		ModelAndView model1;
		EmpMeritDetailsListBean empMeritDetailsListBean;
		
		
		/*if(result.hasErrors()){
			model1 = new ModelAndView("LoginForm");
			
		}*/
		
		List<EmployeeMeritDetails> empMeritDetails = empService.getEmpMeritDetails(user.getUserName());
		
		if(empMeritDetails != null) {
			
			model1 = new ModelAndView("EmpMeritDetails");
			empMeritDetailsListBean = new EmpMeritDetailsListBean();
			empMeritDetailsListBean.setEmpMeritDetail(prepareListOfBean(empMeritDetails));
			model1.addObject("empMeritDetailsListBean", empMeritDetailsListBean);
			return model1;
		}
		else {
			
			model1 = new ModelAndView("EmpMeritDetails");
			model1.addObject("errorMessage", "No result!!!");
			return model1;
		}
		
	}
	
	@RequestMapping(value="/saveEmpMeritDetails.html", method = RequestMethod.POST)
	public ModelAndView SaveEmpMeritDetails(@Valid @ModelAttribute("empMeritDetailsListBean") EmpMeritDetailsListBean list,
			BindingResult result, HttpServletRequest request) {
		
		
		/*if(result.hasErrors()){
			model1 = new ModelAndView("LoginForm");
			
		}*/
		
		List<EmpMeritDetailsBean> empMeritDetails = list.getEmpMeritDetail();
		
		empService.saveEmpMeritDetails(prepareListOfModel(empMeritDetails));
		ModelAndView model1 = new ModelAndView("redirect:/merit/getEmpMeritDetails.html");
		model1.addObject("user", request.getSession().getAttribute("userInfo"));
		
		return model1;	
	}	
	
	private List<EmployeeMeritDetails> prepareListOfModel(List<EmpMeritDetailsBean> empMeritDetailsList) {
		List<EmployeeMeritDetails> modelList = null;
		if(empMeritDetailsList != null && !empMeritDetailsList.isEmpty()){
			modelList = new ArrayList<EmployeeMeritDetails>();
			EmployeeMeritDetails model = null;
			for(EmpMeritDetailsBean empMeritDetails:empMeritDetailsList){
				model = new EmployeeMeritDetails();
				model.setCurrentSalary(empMeritDetails.getCurrentSalary());
				model.setDirectManager(empMeritDetails.getDirectManager());
				model.setEmpId(empMeritDetails.getEmpId());
				model.setFirstName(empMeritDetails.getFirstName());
				model.setHireDate(empMeritDetails.getHireDate());
				model.setJobTitle(empMeritDetails.getJobTitle());
				model.setL1Manager(empMeritDetails.getL1Manager());
				model.setL2Manager(empMeritDetails.getL2Manager());
				model.setL3Manager(empMeritDetails.getL3Manager());
				model.setLastName(empMeritDetails.getLastName());
				model.setLastSalaryHikeDate(empMeritDetails.getLastSalaryHikeDate());
				model.setMeritCycle(empMeritDetails.getMeritCycle());
				model.setMeritSystem(empMeritDetails.getMeritSystem());
				model.setPerformanceSurvey(empMeritDetails.getPerformanceSurvey());
				model.setRecommendedSalAmt(empMeritDetails.getRecommendedSalAmt());
				model.setRecommendedSalPerc(empMeritDetails.getRecommendedSalPerc());
				model.setSalAfterMerit(empMeritDetails.getSalAfterMerit());
				model.setTargetPercentage(empMeritDetails.getTargetPercentage());
				model.setTargetSalary(empMeritDetails.getTargetSalary());
				model.setType(empMeritDetails.getType());
				modelList.add(model);
			}
		}
		
		return modelList;
		
	}
			
		
	
	private List<EmpMeritDetailsBean> prepareListOfBean(List<EmployeeMeritDetails> empDetails){
		
		List<EmpMeritDetailsBean> beans = null;
		
		if(empDetails != null && !empDetails.isEmpty()){
			beans = new ArrayList<EmpMeritDetailsBean>();
			EmpMeritDetailsBean bean = null;
			
			for(EmployeeMeritDetails empMeritDetail : empDetails){
				bean = new EmpMeritDetailsBean();
				bean.setCurrentSalary(empMeritDetail.getCurrentSalary());
				bean.setDirectManager(empMeritDetail.getDirectManager());
				bean.setEmpId(empMeritDetail.getEmpId());
				bean.setFirstName(empMeritDetail.getFirstName());
				bean.setHireDate(empMeritDetail.getHireDate());
				bean.setJobTitle(empMeritDetail.getJobTitle());
				bean.setL1Manager(empMeritDetail.getL1Manager());
				bean.setL2Manager(empMeritDetail.getL2Manager());
				bean.setL3Manager(empMeritDetail.getL3Manager());
				bean.setLastName(empMeritDetail.getLastName());
				bean.setLastSalaryHikeDate(empMeritDetail.getLastSalaryHikeDate());
				bean.setMeritCycle(empMeritDetail.getMeritCycle());
				bean.setMeritSystem(empMeritDetail.getMeritSystem());
				bean.setPerformanceSurvey(empMeritDetail.getPerformanceSurvey());
				bean.setRecommendedSalAmt(empMeritDetail.getRecommendedSalAmt());
				bean.setRecommendedSalPerc(empMeritDetail.getRecommendedSalPerc());
				bean.setSalAfterMerit(empMeritDetail.getSalAfterMerit());
				bean.setTargetPercentage(empMeritDetail.getTargetPercentage());
				bean.setTargetSalary(empMeritDetail.getTargetSalary());
				bean.setType(empMeritDetail.getType());
				beans.add(bean);
		   }
		  }
		  return beans;
		 }
	
	
}
