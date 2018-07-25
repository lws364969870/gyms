package com.dream.gyms.dingtalk.service;

import com.dream.gyms.common.service.BaseService;
import com.dream.gyms.dingtalk.entity.AccessToken;

public interface AccessTokenService extends BaseService<AccessToken> {

	public String getAccessToken() throws Exception;

	/**
	 * insert access_token 返回ID
	 * 
	 * @author lws
	 */
	public int insertAccessToken(AccessToken accesstoken);
}
