package org.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    this is where we add all of our related advices for logging

    // start with @Before type method
//    @Before("execution(* add*(org.example.aopdemo.Account, ..))")
//    @Before("execution(* add*(..))")

//    in a package
    @Before("execution(* org.example.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========>>> Executing @Before advice on method");
    }

}
