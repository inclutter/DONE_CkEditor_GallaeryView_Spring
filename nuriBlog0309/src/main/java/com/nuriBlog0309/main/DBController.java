package com.nuriBlog0309.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DBController {
	
	@RequestMapping(value = "/insert.do")
	public ModelAndView insertBoard(HttpServletRequest request, VO vo) {
		String viewName="home";
		ModelAndView mav = new ModelAndView(viewName);
		System.out.println("이미지값 : "+vo.getImage_name());
		return mav;
	}
}
