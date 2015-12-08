package com.apress.isf.spring.data;

import com.apress.isf.java.model.Type;

public interface TypeDataDAO {
	public Type[] getAll();
	//지정한 id를 기반으로 Type을 얻게 한다.
	public Type findById(String id);
	
}
