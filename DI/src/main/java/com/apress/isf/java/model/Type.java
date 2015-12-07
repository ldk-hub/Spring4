package com.apress.isf.java.model;

public class Type {

	
	//데이터 형식 정의 자동 겟셋 할 것 일일이 타이핑 X
	private String name;
	private String desc;
	private String extension;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
}
