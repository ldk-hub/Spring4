package com.apress.isf.spring.data;

import com.apress.isf.java.model.Document;

public interface DocumentDAO {
	
	public Document[] getAll();
	//DocumentRepository의 데이터타입및 데이터를 배열로담는다.
}
