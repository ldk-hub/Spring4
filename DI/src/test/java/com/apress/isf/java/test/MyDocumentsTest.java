package com.apress.isf.java.test;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.MySearchEngine;
import com.apress.isf.java.service.SearchEngine;

public class MyDocumentsTest {
	//JUnit 으로  각  클래스마다 log를 심었는데 그 log를 호출하여 정상적으로 Test해보는 것으로 추후 각 메서드 별 기능에 대해 학습 진행예정
	//유닛테스트
    private SearchEngine engine = new MySearchEngine();

    @Test
    public void testFindByType() {
        Type documentType = new Type();
        documentType.setName("WEB");
        documentType.setDesc("Web Link");
        documentType.setExtension(".url");
		
        List<Document> documents = engine.findByType(documentType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(documentType.getName(), documents.get(0).getType().getName());
        assertEquals(documentType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(documentType.getExtension(),
            documents.get(0).getType().getExtension());
	}
	
    @Test
    public void testListAll() {		
        List<Document> documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }

}
