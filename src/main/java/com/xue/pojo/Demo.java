package com.xue.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 样例 pojo
 * @author xuejx 2015-9-24
 * 
 */
public class Demo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String address;
	private String sex;
	private String work;

	private Date createDate;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public Demo() {
	}

	public Demo(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 处理日期的方法
	 * @return
	 */
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return String.format("Demo [id=%s, name=%s]", id, name);
	}

	
	
}
