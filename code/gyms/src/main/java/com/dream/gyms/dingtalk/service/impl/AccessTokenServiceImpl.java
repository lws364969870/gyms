package com.dream.gyms.dingtalk.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dream.gyms.common.service.impl.BaseServiceImpl;
import com.dream.gyms.dingtalk.entity.AccessToken;
import com.dream.gyms.dingtalk.mapper.AccessTokenMapper;
import com.dream.gyms.dingtalk.mapper.SsoTokenMapper;
import com.dream.gyms.dingtalk.service.AccessTokenService;
import com.dream.gyms.dingtalk.utils.AuthHelper;

@Service("AccessTokenService")
@Transactional
public class AccessTokenServiceImpl extends BaseServiceImpl<AccessToken> implements AccessTokenService {

	// 固定数据库中TOKEN的ID
	private final long DEFAULT_DB_TOKEN_ID = 1;

	// 过期时间：1小时50分钟
	private final long CACHE_TIME = 1000 * 60 * 55 * 2;

	@Resource
	private AccessTokenMapper accessTokenMapper;

	@Resource
	private SsoTokenMapper ssoTokenMapper;

	// @Resource
	// private DemoMapper demoMapper;

	/**
	 * 保存access_token
	 * 
	 * @author lws
	 * @param accesstoken
	 * @return
	 */
	// @Override
	public int saveAccessToken(AccessToken accesstoken) {

		int result = 0;
		if (null != accesstoken.getId()) {
			result = accessTokenMapper.updateByPrimaryKey(accesstoken);
		} else {
			result = accessTokenMapper.insertAccessToken(accesstoken);
		}
		return result;
	}

	/**
	 * insert access_token 返回ID
	 * 
	 * @author lws
	 */
	@Override
	public int insertAccessToken(AccessToken accesstoken) {
		int result = accessTokenMapper.insertAccessToken(accesstoken);
		return result;
	}

	/**
	 * 清空所有DB access_token
	 * 
	 * @author lws
	 */
	// @Override
	public int deleteAllAccessToken() {
		int result = accessTokenMapper.deleteAllAccessToken();
		return result;
	}

	// {"expires_in":7200,"errmsg":"ok","access_token":"aeacac361301366da73d0d2b15d5c276","errcode":0}
	/**
	 * 获取access_token
	 */
	// @Override
	public String getAccessToken() throws Exception {
		// 先查询数据库是否有值，有值校验日期，没值请求钉钉获取token
		AccessToken accessToken = this.queryById(DEFAULT_DB_TOKEN_ID);
		String token = "";
		if (null != accessToken) {
			long endTime = accessToken.getEndTime().getTime();
			if (new Date().getTime() < (endTime + CACHE_TIME) && StringUtils.isNotBlank(accessToken.getAccessToken())) {
				token = accessToken.getAccessToken();
			} else {
				// 超时
				// deleteAllAccessToken();
				token = AuthHelper.getAccessToken();
				accessToken = new AccessToken();
				accessToken.setId(DEFAULT_DB_TOKEN_ID);
				accessToken.setAccessToken(token);
				accessToken.setEndTime(new Timestamp(new Date().getTime()));
				this.saveAccessToken(accessToken);
			}
		} else {
			// 数据库查询为空
			token = AuthHelper.getAccessToken();
			accessToken = new AccessToken();
			accessToken.setId(DEFAULT_DB_TOKEN_ID);
			accessToken.setAccessToken(token);
			accessToken.setEndTime(new Timestamp(new Date().getTime() + 7200));
			this.insert(accessToken);
		}

		return token;
	}
}
