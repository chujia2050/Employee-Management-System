package com.example.employeemanagementsystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class loggingAspect {

    private Logger mylogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.example.employeemanagementsystem.controller.*.*(..))")
    private void forControllerPackage() {

    }

    @Pointcut("execution(* com.example.employeemanagementsystem.service.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("execution(* com.example.employeemanagementsystem.dao.*.*(..))")
    private void forDAOPackage() {

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow(){

    }

    @Before("forAppFlow()")
    private  void before(JoinPoint joinPoint){

        String method = joinPoint.getSignature().toShortString();
        mylogger.info("=====> in @Before: calling method: " + method);

        Object[] args = joinPoint.getArgs();
        for(Object arg: args){
            mylogger.info("=====> arg: " + arg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    private  void afterReturning(JoinPoint joinPoint, Object result){

        String method = joinPoint.getSignature().toShortString();
        mylogger.info("=====> in @AfterReturning: from method: " + method);

        mylogger.info("=====> in result: " + result);
    }
}
