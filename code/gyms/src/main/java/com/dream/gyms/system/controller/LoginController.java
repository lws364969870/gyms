package com.dream.gyms.system.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dream.gyms.system.entity.User;

@Controller
@RequestMapping(value="/LoginController")
public class LoginController {

	/*@RequestMapping(value="/login")
	public String login(String param){
		
		return "login";
	}
	
	@RequestMapping(value="/demo")
	public String demo(String param){
		
		return "demo";
	}
	
	@RequestMapping(value="/logout")
	public String logout(String param){
		
		return "../../login";
	}
	*/
	
	/**
     * 向用户登录页面跳转
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        return  "login";
    }

    /**
     * 用户登录
     * @param user
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session){
        //获取用户名和密码
        String username=user.getUsername();
        String password=user.getPassword();
        //些处横板从数据库中获取对用户名和密码后进行判断
        if(username!=null&&username.equals("admin")&&password!=null&&password.equals("admin")){
            //将用户对象添加到Session中
            session.setAttribute("USER_SESSION",user);
            //重定向到主页面的跳转方法
            return "redirect:main";
        }
        model.addAttribute("msg","用户名或密码错误");
        return "login";
    }

    @RequestMapping(value = "/main")
    public String toMain(){
        return "main";
    }
    
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        //清除session
        session.invalidate();
        //重定向到登录页面的跳转方法
        return "redirect:login";
    }
}
