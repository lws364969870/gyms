package com.dream.gyms.dingtalk.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * sso_token对象
 * 
 * @author lws
 * 
 */
@Table(name = "sso_token")
public class SsoToken {
	@Id
	public Long id;

	@Column(name = "sso_token")
	public String ssoToken;

	@Column(name = "end_time")
	public Timestamp endTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSsoToken() {
		return ssoToken;
	}

	public void setSsoToken(String ssoToken) {
		this.ssoToken = ssoToken;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

}
