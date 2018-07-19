package com.dream.gyms.dingtalk.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import tk.mybatis.mapper.common.Mapper;

import com.dream.gyms.dingtalk.entity.AccessToken;

public interface AccessTokenMapper extends Mapper<AccessToken> {

	/**
	 * insert返回ID
	 * 
	 * @author lws
	 * @param accessToken
	 */
	@Insert("insert into access_token (access_token, end_time) values (#{accessToken}, #{endTime})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int insertAccessToken(AccessToken accessToken);

	/**
	 * 清空所有DB token
	 * 
	 * @author lws
	 */
	@Delete("delete from access_token")
	public int deleteAllAccessToken();
}
