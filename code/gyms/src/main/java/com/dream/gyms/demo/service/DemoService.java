package com.dream.gyms.demo.service;

import com.dream.gyms.common.service.BaseService;
import com.dream.gyms.demo.entity.Demo;

public interface DemoService extends BaseService<Demo> {

	void testInsert();

	void testSelect();

	void testUpdate();

	void testDelete();

}
