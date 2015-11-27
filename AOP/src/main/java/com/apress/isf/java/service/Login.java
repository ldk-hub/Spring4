package com.apress.isf.java.service;

public interface Login {
	//isAuthorized메서드는 기본권한부여 로직만 수행하며, 두파라미터값이 모두 주입된 프로퍼티값과 같을경우에만 true를 리턴한다.
	public boolean isAuthorized(String email, String pass);
}
