package com.dream.gyms.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "demo")
public class Demo {

	@Id
	private Long fid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
