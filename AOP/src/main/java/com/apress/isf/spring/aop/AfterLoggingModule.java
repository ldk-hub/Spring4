package com.apress.isf.spring.aop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;

public class AfterLoggingModule implements AfterReturningAdvice {

	
	private static final Logger log = LoggerFactory.getLogger(AfterLoggingModule.class);
	
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target)throws Throwable{
		if(log.isDebugEnabled()){
			log.debug("@@@@(AFTER)�޼ҵ� ȣ��:" +method.getName());
			if(args.length==0)
				log.debug("@@@@(AFTER)�ȵȴ�.");
			for(Object arg:args)
				log.debug("@@@@(AFTER) �ƱԸ�Ʈ �н�����:"+ arg);
			log.debug("@@@(AFTER)Result:"+returnValue);
		}
	}
	
}
