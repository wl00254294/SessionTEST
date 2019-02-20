package com.eric.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        return  "login";
    }
	
	@RequestMapping(value = "/loginact",method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model, HttpSession session){
        //获取用户名和密码
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //些处横板从数据库中获取对用户名和密码后进行判断
        if(username!=null&&username.equals("admin")&&password!=null&&password.equals("admin")){
            //将用户对象添加到Session中
            session.setAttribute("USERNAME",username);
            //重定向到主页面的跳转方法
            return "redirect:home";
        }
        model.addAttribute("msg","用户名或密码错误，请重新登录！");
        model.addAttribute("iname","無效帳號 "+username);
        model.addAttribute("ipwd","無效密碼 "+password);
        
        return "login";
    }
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		String uname=(String)session.getAttribute("USERNAME");
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("uname",uname);
		return "home";
	}
	
	  @RequestMapping(value = "/logout")
	    public String logout(HttpSession session){
	        //清除session
	        session.invalidate();
	        //重定向到登录页面的跳转方法
	        return "redirect:login";
	    }
	
}
