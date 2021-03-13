package com.in28minutes.spring.aop.springaop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
    @Pointcut("execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))")
    public void businessLayerExecution(){}

    @Pointcut("execution(* com.in28minutes.spring.aop.springaop.data.*.*(..))")
    public void dataLayerExecution(){}

}
