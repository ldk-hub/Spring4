package com.apress.isf.spring.aop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;



public class ThrowsLoggingModule implements ThrowsAdvice{
	
	private static final Logger log = LoggerFactory.getLogger(ThrowsLoggingModule.class);
	//afterThrowing 주석처리
	public void afterThrowing(Method m, Object[] args, Object target, Exception ex){
		
		if(log.isDebugEnabled()){
			log.debug("@@@(Throws)메소드"+m.getName());
			if(args.length==0)
				log.debug("@@@(Throws)노아규먼트");
			for(Object arg:args)
				log.debug("@@@(Throws) 아규먼트"+arg);
			log.debug("@@@(Throws)에러"+ex.getMessage());
		}
	}
	
}
