package com.dream.gyms.dingtalk.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import tk.mybatis.mapper.common.Mapper;

import com.dream.gyms.dingtalk.entity.SsoToken;

public interface SsoTokenMapper extends Mapper<SsoToken> {

	/**
	 * insert返回ID
	 * 
	 * @author lws
	 * @param ssoToken
	 */
	@Insert("insert into sso_token (sso_token, end_time) values (#{ssoToken}, #{endTime})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int insertSsoToken(SsoToken ssoToken);

	/**
	 * 清空所有DB token
	 * 
	 * @author lws
	 */
	@Delete("delete from sso_token")
	public int deleteAllSsoToken();
}
