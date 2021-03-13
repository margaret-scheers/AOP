package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    //execution(* PACKAGE.*.*(..))
    //execution(returnType Package.class.method(args))
    //to get subpackages add an extra dot after the package
    //execution(returnType Package..class.method(args))

    //terms  we are weaving and the framework is a weaver

    //specifying the classes to check is a pointcut
    @Before("execution(* com.in28minutes.spring.aop.springaop..*.*(..))")
    public void before(JoinPoint joinPoint) {
        //you do not need to check access in every class, you can
        // do it here

        //ADVICE
        logger.info("Check user access");
        logger.info(" Intercepted Method Call - {}", joinPoint);
    }
}
