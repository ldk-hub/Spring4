package com.apress.isf.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AroundLoggingModule implements MethodInterceptor {

	private static final Logger log = LoggerFactory.getLogger(AroundLoggingModule.class);

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;
		if (log.isDebugEnabled()) {
			log.debug("@@@@(Around-Before)메소드 콜" + invocation.getMethod().getName());
			if (invocation.getArguments().length ==0)
			log.debug("@@@@(Around-Before)아규먼트 없어서 패스");
			for (Object arg : invocation.getArguments())
				log.debug("@@@@(Around-Before) 아규먼트 패스" + arg);
		}
		try {
			if (log.isDebugEnabled())
				log.debug("@@@@(Around)진행중");
			result = invocation.proceed();
			if (log.isDebugEnabled())
				log.debug("@@@(Around-After)결과:" + result);

			return result;
		} catch (IllegalArgumentException ex) {
			log.error("@@@(Around) Throws an exception:" + ex.getMessage());
			throw ex;
		}
	}

}
