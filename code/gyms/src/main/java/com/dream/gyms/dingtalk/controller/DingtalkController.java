package com.dream.gyms.dingtalk.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.gyms.dingtalk.service.AccessTokenService;

@Controller
@RequestMapping(value = "/dingtalk")
public class DingtalkController {

	@Resource
	AccessTokenService accessTokenService;

	@RequestMapping(value = "/getAccessToken")
	@ResponseBody
	public String getAccessToken(String param) {

		try {
			return accessTokenService.getAccessToken();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "获取失败";

	}
}
