package com.apress.isf.spring.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.data.DocumentDAO;
import com.apress.isf.spring.data.DocumentRepository;
import com.apress.isf.spring.service.SearchEngineService;

@Configuration //여기에 빈들이 정의되어있다 알리는 어노테이션
public class MyDocumentsContext {
    //맵에 각데이터를 문자형 키,데이터 로 담는다.
    private Map<String,Document> documents = new HashMap<String,Document>();
    private Map<String,Type> types = new HashMap<String,Type>();

    @Bean//빈테그와 프로퍼티설정이 기존 빈정의와 동일 연관 빈을 스프링컨테이너에 알린다.
    public Type webType() {
        return getTypeFromMap("web");
    }
    
    @Bean
    public SearchEngine engine() {
        SearchEngineService engine = new SearchEngineService();
        engine.setDocumentDAO(documentDAO());
        return engine;
    }
    
    public MyDocumentsContext() {//빈의 프로퍼티 설정 내역
        Type type = new Type();
        type.setName("PDF");
        type.setDesc("Portable Document Format");
        type.setExtension(".pdf");
        
        Document document = new Document();
        document.setName("Book Template");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Random/Book Template.pdf");
        
        documents.put("doc1", document);
        types.put("pdf", type);
        
        document = new Document();
        document.setName("Sample Contract");
        document.setType(type);
        document.setLocation(
            "/Users/felipeg/Documents/Contracts/Sample Contract.pdf");
        
        documents.put("doc2", document);
        
        type = new Type();
        type.setName("NOTE");
        type.setDesc("Text Notes");
        type.setExtension(".txt");
        
        document = new Document();
        document.setName("Clustering with RabbitMQ");
        document.setType(type);
        document.setLocation(
            "/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");
        
        documents.put("doc3", document);
        types.put("note", type);
        
        type = new Type();
        type.setName("WEB");
        type.setDesc("Web Link");
        type.setExtension(".url");
        
        document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");
        
        documents.put("doc4", document);
        types.put("web", type);
    }
    
    private DocumentDAO documentDAO() {
        DocumentRepository documentDAO = new DocumentRepository();
        documentDAO.setDoc1(getDocumentFromMap("doc1"));
        documentDAO.setDoc2(getDocumentFromMap("doc2"));
        documentDAO.setDoc3(getDocumentFromMap("doc3"));
        documentDAO.setDoc4(getDocumentFromMap("doc4"));
        return documentDAO;
    }
    
    private Document getDocumentFromMap(String documentKey) {
        return documents.get(documentKey);
    }
    
    private Type getTypeFromMap(String typeKey) {
        return types.get(typeKey);
    }
}
