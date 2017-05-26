package com.xpo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.xpo.bean.EmpMeritDetailsBean;
import com.xpo.bean.UserBean;
import com.xpo.model.EmployeeMeritDetails;
import com.xpo.service.EmpMeritDetailsService;


@Controller
@SessionAttributes("userInfo")
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
	
	

	
	/*@ModelAttribute()
	public void setHeader(Model model, HttpServletRequest request) {
		
		
		
	}*/
	
	@RequestMapping(value="/getEmpMeritDetails.html", method = RequestMethod.POST)
	public ModelAndView LoginSubmitAsModelAttribute(@Valid @ModelAttribute("user") UserBean user, 
			BindingResult result) {
		
		ModelAndView model1;
		
		
		/*if(result.hasErrors()){
			model1 = new ModelAndView("LoginForm");
			
		}*/
		
		List<EmployeeMeritDetails> empMeritDetails = empService.getEmpMeritDetails(user.getUserName());
		
		if(empMeritDetails != null) {
			
			model1 = new ModelAndView("EmpMeritDetails");
			model1.addObject("empMeritDetails", prepareListofBean(empMeritDetails));
			return model1;
		}
		else {
			
			model1 = new ModelAndView("EmpMeritDetails");
			model1.addObject("errorMessage", "No result!!!");
			return model1;
		}
		
	}	
		
	
	private List<EmpMeritDetailsBean> prepareListofBean(List<EmployeeMeritDetails> empDetails){
		
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
