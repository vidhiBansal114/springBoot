package com.example.website.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.website.domain.StudentUser;
import com.example.website.domain.User;
import com.example.website.service.UserService;

@Controller
public class SignUpController {
	@Autowired
	UserService userservice;
	@RequestMapping("/signup")
	public String getSignUpPage(Model uiModel) {
		User user=userservice.getUser();
		uiModel.addAttribute("user",user);
		return "signup";
		
	}
	@RequestMapping("/registerUser")
	public String createdUser(@ModelAttribute(value="user") StudentUser studentUser) {
		int userId=userservice.signUp(studentUser.getName(),studentUser.getGender(),studentUser.getLocation(),studentUser.getCollege());
		if(userId!=-1){
			ModelAndView modelAndView=new ModelAndView("redirect:welcome?id="+userId);
			return modelAndView.getViewName();
		}
		return "signup";
	}
	@RequestMapping("/welcome")
	public String showWelcomePage(@RequestParam("id") String userID,ModelMap map ) {
		map.addAttribute("userID",userID);
		return "welcome";
		
	}
	@RequestMapping("/profile/{profileID}")
	public String showProfile(@PathVariable("profileID") String profileID,ModelMap modelMap) {
		modelMap.addAttribute("profileID", profileID);
		return "profile";
	}

}
