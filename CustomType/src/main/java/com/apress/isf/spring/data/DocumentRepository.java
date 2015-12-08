package com.apress.isf.spring.data;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apress.isf.java.model.Document;

public class DocumentRepository implements DocumentDAO {

	//각 컨텍스트 설정에서 내부로그를 많이 심어 로직상 어떤 상황이 발생하는지 Log기록을 더 많이 넣었다.
	private static final Logger log =
	    LoggerFactory.getLogger(DocumentRepository.class);
	private List<Document> documents = null;

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document[] getAll() { 
		if (log.isDebugEnabled())//로그를 Document배열에 심어 실행될때 정상적으로 구동되는지 유닛 테스트를 할 수 있다.
			log.debug("Start <getAll> Params: ");
		Document[] result = documents.toArray(new Document[documents.size()]);

		if (log.isDebugEnabled())
			log.debug("End <getAll> Result:" + result);
		return result;
	}

}
