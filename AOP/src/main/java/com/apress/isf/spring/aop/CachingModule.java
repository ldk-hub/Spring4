package com.apress.isf.spring.aop;

import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apress.isf.java.model.Type;

public class CachingModule implements MethodInterceptor {

	private static final Logger log = LoggerFactory.getLogger(CachingModule.class);
	private static final Map<String, Object> cache = new HashMap<String, Object>();

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;
		Type documentType = null;

		log.debug("@@@(Caching)캐시 호출중...");

		if ("findByType".equals(invocation.getMethod().getName()) && invocation.getArguments().length == 1
				&& invocation.getArguments()[0] instanceof Type) {
			documentType = (Type) invocation.getArguments()[0];
			log.debug("@@@(Caching)캐시를 찾는중..");
			if (cache.containsKey(documentType.getName())) {
				log.debug("@@@(Caching)연결");
				return cache.get(documentType.getName());
			}
			log.debug("@@@(Caching)찾을수 없습니다. ");
			result = invocation.proceed();
			cache.put(documentType.getName(), result);
			return result;

		}
		return invocation.proceed();

	}
}