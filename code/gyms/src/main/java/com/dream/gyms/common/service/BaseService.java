package com.dream.gyms.common.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

public interface BaseService<T> {

	// 根据id查询实体
	public T queryById(Long id);

	// 查询所有
	public List<T> queryAll();

	// 条件查询
	public List<T> queryListByWhere(T param);

	// 查询记录数
	public Integer queryCount(T param);

	// 分页
	public PageInfo<T> queryPageListByWhere(T param, Integer page, Integer rows);

	// 查询一条记录
	public T queryOne(T param);

	// 插入
	public Integer save(T param);

	// 新增非空字段
	public Integer saveSelect(T param);

	// 根据主键更新
	public Integer update(T param);

	// 根据主键更新非空字段
	public Integer updateSelective(T param);

	// 根据主键删除
	public Integer deleteById(Long id);

	// 批量删除
	public Integer deleteByIds(Class<T> clazz, List<Object> values);

}
