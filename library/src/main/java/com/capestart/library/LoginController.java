package com.capestart.library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse)
	{
		ModelAndView mav= new ModelAndView();
		System.out.println("welcome");
		return null;
	}
}
