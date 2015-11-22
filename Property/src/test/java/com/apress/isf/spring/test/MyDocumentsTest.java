package com.apress.isf.spring.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class MyDocumentsTest {

	private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
	private ClassPathXmlApplicationContext context;

	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-context.xml");
	}

	@Test
	public void testMenu() {
		log.debug("About to read  the Resource file: menu.txt");
		//스프링 리소스 클래스를 사용해 리소스파일을 찾아내어 콘솔에 내용을 출력한다.
		Resource resource = context.getResource("classpath:META-INF/data/menu.txt");
		try {
			InputStream stream = resource.getInputStream();
			Scanner scanner = new Scanner(stream);
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
