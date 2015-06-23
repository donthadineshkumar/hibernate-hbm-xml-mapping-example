package com.entity;

import java.io.Serializable;

/**
 * @author dinesh
 *
 */
public class Player implements Serializable{

	private long pid;
	private String name;
	private Integer age;
	private long tid;
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	
	
}

