package com.apress.isf.spring.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.isf.java.service.Login;

public class MyDocumentsWithLoginTest {

	private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithLoginTest.class);

	private static final String EMAIL = "test@mydocuments.com";
	private static final String PASS = "test123";
	private static final String SUCCESS = "해당유저는 로그인이 되었습니다.라는 로그테스트";
	private static final String FAILURE = "실패했을경우의 출력결과지롱";
	private ClassPathXmlApplicationContext context;

	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-login-context.xml");
	}

	@Test
	public void testLogin() {
		log.debug("Login test.");
		Login login = context.getBean(Login.class);
		assertNotNull(login);
		if (login.isAuthorized(EMAIL, PASS))
			System.out.println(SUCCESS);
		else
			System.out.println(FAILURE);
	}
}
