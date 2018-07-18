package com.dream.gyms.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dream.gyms.common.service.impl.BaseServiceImpl;
import com.dream.gyms.demo.entity.Demo;
import com.dream.gyms.demo.mapper.DemoMapper;
import com.dream.gyms.demo.service.DemoService;

@Service("DemoService")
@Transactional
public class DemoServiceImpl extends BaseServiceImpl<Demo> implements DemoService {

	@Resource
	private DemoMapper demoMapper;

	@Override
	public void testSelect() {
		List<Demo> ls = demoMapper.selectAll();
		System.out.println(ls.size());
	}

	@Override
	public void testUpdate() {
		List<Demo> ls = demoMapper.selectAll();
		System.out.println(ls.size());
	}

	@Override
	public void testDelete() {
		List<Demo> ls = demoMapper.selectAll();
		System.out.println(ls.size());
	}

	@Override
	public void testInsert() {
		Demo a = new Demo();
		a.setFid(2l);
		a.setName("aa");
		super.save(a);
		System.out.println(a.getFid());
	}
}
