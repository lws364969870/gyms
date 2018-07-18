package com.dream.gyms.demo.mapper;

import java.util.List;

import tk.mybatis.mapper.common.Mapper;

import com.dream.gyms.demo.entity.Demo;

public interface DemoMapper extends Mapper<Demo> {

	public List<Demo> findByFid(int fid);
}
