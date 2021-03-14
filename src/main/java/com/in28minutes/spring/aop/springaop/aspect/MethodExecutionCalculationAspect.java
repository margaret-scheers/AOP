package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
    private Logger logger= LoggerFactory.getLogger(this.getClass());


    @Around("com.in28minutes.spring.aop.springaop.CommonJoinPointConfig.trackTimeAnnotation())")
    public void afterThrowing(ProceedingJoinPoint joinPoint) throws Throwable {
        //startTime = x
        long startTime = System.currentTimeMillis();
        //execute
        joinPoint.proceed();
        // end Time =y
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        logger.info(" Time taken by {} is {}", joinPoint, timeTaken);
    }
}
