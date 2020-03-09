package com.nuriBlog0309.main;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
    

    @RequestMapping(value = "")
    public void getList() {
    	System.out.println("===>article Á¢¼Ó!!");
    }
}