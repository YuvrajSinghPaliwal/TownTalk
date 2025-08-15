package com.TownTalk.Configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
	
	// to check performance
	
	private static final Logger LOGGER=LoggerFactory.getLogger(PerformanceMonitorAspect.class);
	
	@Around("execution(* com.TownTalk.Service.PostService.*(..)) || execution(* com.TownTalk.Service.TownService.*(..))")
	public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
		
		long start=System.currentTimeMillis();
		
		Object obj =jp.proceed();// to call function
		
		long end=System.currentTimeMillis();
		
		LOGGER.info("Time taken : "+(end-start));
		
		return obj;
	}
	
	
}
