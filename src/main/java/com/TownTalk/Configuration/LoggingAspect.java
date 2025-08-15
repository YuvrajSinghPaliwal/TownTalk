package com.TownTalk.Configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

	private static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);
	
	// simply ASPECT is an annotation which work on key Concept of AOP 
	// by separating cross-cutting concerns like (logging,security) from core business logic
	
	
	// return type ,class-name-with-package.(args)  // * for all
	// || for using more selected classes or functions
	// joint point store the details of method called (not mandatory)
	@Before("execution(* com.TownTalk.Service.PostService.*(..)) || execution(* com.TownTalk.Service.TownService.*(..))")
	public void logMethodCall(JoinPoint jp) {
		LOGGER.info("Method called --> "+jp.getSignature().getName());
	}
	
	@After("execution(* com.TownTalk.Service.PostService.*(..)) || execution(* com.TownTalk.Service.TownService.*(..))")
	public void logMethodExecuted(JoinPoint jp) {
		LOGGER.info("Method Executed --> "+jp.getSignature());
	}
	
	// this will execute only when there is an problem in method
	@AfterThrowing("execution(* com.TownTalk.Service.PostService.*(..)) || execution(* com.TownTalk.Service.TownService.*(..))")
	public void logMethodCrashed(JoinPoint jp) {
		LOGGER.info("Method Crashed --> "+jp.getSignature());
	}
	
}
