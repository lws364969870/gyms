package com.dream.gyms.dingtalk.service;

import com.dream.gyms.common.service.BaseService;
import com.dream.gyms.dingtalk.entity.SsoToken;

public interface SsoTokenService extends BaseService<SsoToken> {

	public String getSsoToken() throws Exception;
}
