package com.dream.gyms.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dream.gyms.demo.entity.DemoObject;

@RestController //@RestController is a stereotype annotation that combines @ResponseBody and @Controller.
@RequestMapping(value="/DemoController")
public class DemoController {

	
	@RequestMapping(value="/demo1")
	public Map<String, Object> demo1(String param){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", 1);
		map.put("flag", 1);
		return map;
	}
	
	@RequestMapping(value="/demo2")
	public DemoObject demo2(String param){
		DemoObject obj = new DemoObject();
		obj.setId("1");
		obj.setName("aaa");
		return obj;
	}
	
	/**
	 * http://localhost:8080/gyms/DemoController/demo1
	 */
	@RequestMapping(value="/demo3")
	public String demo3(String param){
		
		return "haha";
	}
	
	@RequestMapping(value="/demo4")
	public String demo4(String param,String param2){
		return param+param2;
	}
}
