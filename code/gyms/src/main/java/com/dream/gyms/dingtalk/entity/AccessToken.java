package com.dream.gyms.dingtalk.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Access_Token是企业访问钉钉开放平台全局接口的唯一凭证
 * 
 * @author lws
 * 
 */
@Table(name = "access_token")
public class AccessToken {
	@Id
	public Long id;

	@Column(name = "access_token")
	public String accessToken;

	@Column(name = "end_time")
	public Timestamp endTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

}
