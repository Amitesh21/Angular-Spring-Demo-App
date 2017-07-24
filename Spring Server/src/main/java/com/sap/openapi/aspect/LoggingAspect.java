package com.sap.openapi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javassist.bytecode.SignatureAttribute.MethodSignature;

/**
 * Created by i861135 on 7/5/17.
 */
@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//    @Around("execution(public * com.sap.openapi.service.LoginService.validateAccount*(..))")
//    public void beforeExecution(JoinPoint joinPoint) {
//
//        System.out.println("Entering logger:  " +joinPoint.getSignature());
//        System.out.println("Entering logger:  " +joinPoint.getSignature().getDeclaringTypeName());
//        LOGGER.info("A request was issued for Entering logger: "+joinPoint.toString());
//        Object[] objArr = joinPoint.getArgs();
//        for(Object o : objArr) {
//            System.out.println(o.toString());
//        }
//
////        MethodSignature sig = (MethodSignature)joinPoint.getSignature();
////        System.out.println(sig.getTypeParameters().toString());
//    }

//    @After("execution(public * com.sap.openapi.service.LoginService.*(..))")
//    public void AfterExecution(JoinPoint joinPoint) {
//        System.out.println("Exiting logger: "+joinPoint.toString());
//        LOGGER.info("Exiting from logger: "+joinPoint.toString());
//    }
}
