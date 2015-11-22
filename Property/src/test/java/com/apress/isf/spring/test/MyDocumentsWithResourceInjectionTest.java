package com.apress.isf.spring.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.isf.spring.views.Menu;

public class MyDocumentsWithResourceInjectionTest {

	private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithResourceInjectionTest.class);
	private ClassPathXmlApplicationContext context;

	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-resource-injection-context.xml");
	}

	//�׽�Ʈ �޼��� �߰�
	@Test
	public void testMenu() {
		log.debug("Calling the Menu as Resource Injection:");
		Menu menu = context.getBean(Menu.class);
		assertNotNull(menu);
		menu.printMenu();
	}
}
