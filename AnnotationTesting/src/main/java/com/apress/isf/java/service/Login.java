package com.apress.isf.java.service;

public interface Login {
	//isAuthorized�޼���� �⺻���Ѻο� ������ �����ϸ�, ���Ķ���Ͱ��� ��� ���Ե� ������Ƽ���� ������쿡�� true�� �����Ѵ�.
	public boolean isAuthorized(String email, String pass);
}
