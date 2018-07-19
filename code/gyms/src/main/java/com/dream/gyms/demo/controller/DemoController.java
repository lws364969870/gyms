package com.dream.gyms.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dream.gyms.demo.entity.Demo;
import com.dream.gyms.demo.service.DemoService;

//@RestController is a stereotype annotation that combines @ResponseBody and @Controller.
//http://localhost:8080/gyms/DemoController/demo1
@RestController 
@RequestMapping(value="/DemoController")
public class DemoController {

	@Resource
	private DemoService demoService;
	
	//返回string
	@RequestMapping(value="/demo1")
	public String demo1(String param){
		demoService.testInsert();
		demoService.testSelect();
		return "haha";
	}

	
	//返回string
	@RequestMapping(value="/demo2")
	public String demo2(String param){
		Demo a = new Demo();
		a.setFid(2l);
		a.setName("aa");
		demoService.insert(a);
		return "haha";
	}
}
