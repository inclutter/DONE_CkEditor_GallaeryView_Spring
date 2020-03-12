package com.nuriBlog0309.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DBController {
	
	@Autowired
	DBService dbService;
	
	@RequestMapping(value = "/insert.do")
	public String insertBoard(HttpServletRequest request, VO vo) {
		String result;
		result = vo.getImage_name().substring(vo.getImage_name().indexOf("/image/")+7,vo.getImage_name().indexOf('"',vo.getImage_name().indexOf("/image/")));
		vo.setImage_name(result);
		System.out.println("이미지만 : "+result);
		dbService.insertDB(vo);
		return "redirect:/";
	}
}
