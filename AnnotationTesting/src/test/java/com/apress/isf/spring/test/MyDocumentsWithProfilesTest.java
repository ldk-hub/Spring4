package com.apress.isf.spring.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;

@RunWith(SpringJUnit4ClassRunner.class)//이건 순수 JUnit애너테이션으로 유닛테스트수행하는데 JUnit대신 스프링클래스를사용하는것이다.
                                         //스프링 통합테스팅의 모든기능을 사용가능하다. 
@ContextConfiguration("classpath:META-INF/spring/mydocuments-profiles-context.xml")//이것도 스프링테스팅일부의 애너테이션이다.
@ActiveProfiles("dev")//스프링 컨테이너에 사용할 프로파일과 해당프로파일에서 사용하기 위해 생성할 빈을 알려준다.
public class MyDocumentsWithProfilesTest {
	private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithProfilesTest.class);

	@Autowired//접근할 수 있는 빈들을 준비하는데 도와주는 애너테이션
	private SearchEngine engine;
	@Autowired
	private Type webType;

	@Test
	public void testUsingSpringTestWithProfiles() {

		try {
			log.debug("Using Spring Test fixtures:");

			List<Document> documents = engine.findByType(webType);
			assertNotNull(documents);
			assertTrue(documents.size() == 1);
			assertEquals(webType.getName(), documents.get(0).getType().getName());
			assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
			assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());

			documents = engine.listAll();
			assertNotNull(documents);
			assertTrue(documents.size() == 4);
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}

	}
}
