package com.dream.gyms.dingtalk.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.dream.gyms.common.service.impl.BaseServiceImpl;
import com.dream.gyms.dingtalk.entity.SsoToken;
import com.dream.gyms.dingtalk.mapper.SsoTokenMapper;
import com.dream.gyms.dingtalk.service.SsoTokenService;
import com.dream.gyms.dingtalk.utils.AuthHelper;

public class SsoTokenServiceImpl extends BaseServiceImpl<SsoToken> implements SsoTokenService {

	// 固定数据库中TOKEN的ID
	private final long DEFAULT_DB_TOKEN_ID = 1;

	// 过期时间：1小时50分钟
	private final long CACHE_TIME = 1000 * 60 * 55 * 2;

	@Resource
	private SsoTokenMapper ssoTokenMapper;

	@Autowired
	public void setSsoTokenMapper() {
		super.setMapper(this.ssoTokenMapper);
	}

	/**
	 * 保存
	 * 
	 * @param ssotoken
	 * @return
	 */
	public int saveSsoToken(SsoToken ssotoken) {
		int result = 0;
		if (null != ssotoken.getId()) {
			result = ssoTokenMapper.updateByPrimaryKey(ssotoken);
		} else {
			result = ssoTokenMapper.insertSsoToken(ssotoken);
		}
		return result;
	}

	/**
	 * 获取sso_token
	 */
	@Override
	public String getSsoToken() throws Exception {
		// 先查询数据库是否有值，有值校验日期，没值请求钉钉获取token
		SsoToken ssoToken = this.queryById(DEFAULT_DB_TOKEN_ID);
		String token = "";
		if (null != ssoToken) {
			long endTime = ssoToken.getEndTime().getTime();
			if (new Date().getTime() < (endTime + CACHE_TIME) && StringUtils.isNotBlank(ssoToken.getSsoToken())) {
				token = ssoToken.getSsoToken();
			} else {
				// 超时
				// deleteAllSsoToken();
				token = AuthHelper.getSsoToken();
				ssoToken = new SsoToken();
				ssoToken.setId(DEFAULT_DB_TOKEN_ID);
				ssoToken.setSsoToken(token);
				ssoToken.setEndTime(new Timestamp(new Date().getTime()));
				this.saveSsoToken(ssoToken);
			}
		} else {
			// 数据库查询为空
			token = AuthHelper.getSsoToken();
			ssoToken = new SsoToken();
			ssoToken.setId(DEFAULT_DB_TOKEN_ID);
			ssoToken.setSsoToken(token);
			ssoToken.setEndTime(new Timestamp(new Date().getTime() + 7200));
			this.insert(ssoToken);
		}

		return token;
	}

}
