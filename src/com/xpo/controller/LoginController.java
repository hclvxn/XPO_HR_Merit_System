package com.xpo.controller;

import javax.validation.Valid;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.util.MatcherAssertionErrors;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.xpo.bean.UserBean;
import com.xpo.model.User;
import com.xpo.service.LoginService;

import sun.security.krb5.internal.PAData.SaltAndParams;


@Controller
@SessionAttributes("userInfo")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//binder.setDisallowedFields(new String[] {"password"});;
		//SimpleDateFormat df = new SimpleDateFormat("yyyy***mm***yy");
		//binder.registerCustomEditor(Date.class, "loginDate", new CustomDateEditor(df, false));
		//binder.registerCustomEditor(String.class, "userName", new UserNameEditor());
	}
	
	@RequestMapping(value="/Login.html", method = RequestMethod.GET)
	public ModelAndView LoginRedirect() {
		
				ModelAndView model = new ModelAndView("LoginForm");
				return model;
				
		
	}

	

	
	/*@ModelAttribute()
	public void setHeader(Model model, HttpServletRequest request) {
		
		UserBean user = new UserBean();
		user.setPassword(request.getParameter("password"));
		user.setUserId("userName");
		model.addAttribute("userInfo", user);
		
	}*/
	
	@RequestMapping(value="/Login_Submit", method = RequestMethod.POST)
	public ModelAndView LoginSubmitAsModelAttribute(@Valid @ModelAttribute("user") UserBean user, 
			BindingResult result) {
		
		ModelAndView model1;
		
		
		/*if(result.hasErrors()){
			model1 = new ModelAndView("LoginForm");
			
		}*/
		
		User userModel = loginService.getEmployee(user.getUserName());
		if(BCrypt.checkpw(user.getPassword(), userModel.getPassword())){
			
					
			model1 = new ModelAndView("forward:/merit/getEmpMeritDetails.html");
			model1.addObject("userInfo", user);
		}
		else {
			
			model1 = new ModelAndView("LoginForm");
			model1.addObject("errorMessage", "Invalid Login. Please try again");
		}
		
		return model1;
	}	
		
	
	
	
}
