package com.springboot.BankingApp.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAspect {
	private final Logger logger=Logger.getLogger(getClass().getName());
	 private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Pointcut("execution(* com.springboot.BankingApp.controller.*.*(..))")
	public void restController() {}
	
	@Before("restController()")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("Request : method is "+joinPoint.getSignature().toShortString());
	}
	
	@AfterReturning(pointcut="restController()",returning="response")
	public void logAfterReturning(JoinPoint joinPoint,Object response) {
		logger.info("Response : from method "+joinPoint.getSignature().toShortString()+" is ---> "+response.toString());
	}
	
	@Around("restController()")
	public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		Object response=proceedingJoinPoint.proceed();
		
		ResponseEntity<?> responseEntity = (ResponseEntity<?>) response;
		String responseBody=objectMapper.writeValueAsString(responseEntity.getBody());
		
		logger.info(""+responseBody);
		return response;
	}
}
