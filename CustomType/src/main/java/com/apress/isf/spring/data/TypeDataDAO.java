package com.apress.isf.spring.data;

import com.apress.isf.java.model.Type;

public interface TypeDataDAO {
	public Type[] getAll();
	//������ id�� ������� Type�� ��� �Ѵ�.
	public Type findById(String id);
	
}
