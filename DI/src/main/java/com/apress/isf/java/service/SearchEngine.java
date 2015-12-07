package com.apress.isf.java.service;

import java.util.List;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;

//이인터페이스는 특정문서 유형을 검색하고 해당하는 모든 문서를 추출하는 역할
public interface SearchEngine {    
	
    public List<Document> findByType(Type documentType);
    public List<Document> listAll();
}
