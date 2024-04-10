package com.example.website.web;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.website.service.UserMessageService;

@Controller
public class SupportController {
	
	@Autowired
	UserMessageService userMessageService;
	
@RequestMapping("/support")
	public String getSupportPage(@RequestParam("id") String id, ModelMap uiModel) {
		String finalUserMessage=userMessageService.createMessage(Integer.parseInt(id));
		uiModel.addAttribute("message",finalUserMessage);
		return "support";
		
	}
@RequestMapping("/instructors")
	public String showInstructors(ModelMap modelmap) {
	HashMap<String,Object> instructor=new HashMap();
	instructor.put("name","Rahul");
	instructor.put("age", 27);
	instructor.put("id", 123);
	ArrayList<HashMap<String,Object>> listOfInstructors=new ArrayList<HashMap<String,Object>>();
	listOfInstructors.add(instructor);
	modelmap.addAttribute("instructors", listOfInstructors);
	return "instructors";
	
}
}
