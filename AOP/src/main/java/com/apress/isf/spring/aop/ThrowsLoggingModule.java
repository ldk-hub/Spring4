package com.apress.isf.spring.aop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;



public class ThrowsLoggingModule implements ThrowsAdvice{
	
	private static final Logger log = LoggerFactory.getLogger(ThrowsLoggingModule.class);
	//afterThrowing �ּ�ó��
	public void afterThrowing(Method m, Object[] args, Object target, Exception ex){
		
		if(log.isDebugEnabled()){
			log.debug("@@@(Throws)�޼ҵ�"+m.getName());
			if(args.length==0)
				log.debug("@@@(Throws)��ƱԸ�Ʈ");
			for(Object arg:args)
				log.debug("@@@(Throws) �ƱԸ�Ʈ"+arg);
			log.debug("@@@(Throws)����"+ex.getMessage());
		}
	}
	
}
