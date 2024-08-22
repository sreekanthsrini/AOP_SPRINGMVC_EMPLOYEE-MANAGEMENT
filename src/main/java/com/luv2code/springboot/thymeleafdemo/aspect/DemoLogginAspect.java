package com.luv2code.springboot.thymeleafdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLogginAspect {
    
    // setup logger
    private Logger myLogger=Logger.getLogger(getClass().getName()); 
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forcontrollerpackage(){

    }
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forservicexspackage(){
}

@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDAOpackage(){
}
// the or statement will consider if any one is trur it will work if alll false it cant work
@Pointcut("forcontrollerpackage() ||  forservicexspackage() || forDAOpackage()  ")
private void forAppflow(){

}

// add before advice
@Before("forAppflow()")
public void before(JoinPoint theJoinPoint){
    // display method we are calling
    String theMethod=theJoinPoint.getSignature().toShortString();
    myLogger.info(">>>>before :calling method"+theMethod);


    // dispalay the arguments to the method
    // get the arguments
    Object[] args=theJoinPoint.getArgs();



    // loop thrugh and display the
    for (Object tempargs :args){
        myLogger.info(">>>>>>>>>> argument"+tempargs);
    }
}





    // add after returning
    @AfterReturning(
        pointcut="forappflow()",
        returning="theResult")
        public void AfterReturning(JoinPoint theJoinPoint,Object theResult){
            // display method we are returning frame
            String theMethod=theJoinPoint.getSignature().toShortString();
            myLogger.info("@before calling method"+theMethod);

            // display data returned
            myLogger.info("the result"+theMethod);

        }
    







}






