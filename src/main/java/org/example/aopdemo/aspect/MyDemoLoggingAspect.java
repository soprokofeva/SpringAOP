package org.example.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.aopdemo.Account;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("org.example.aopdemo.aspect.UtilAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinpoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");

//        display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinpoint.getSignature();
        System.out.println("Method: " + methodSignature);
//        display method arguments

//        get args
        Object[] args = theJoinpoint.getArgs();

//        loop thru args
        for (Object arg : args) {
            System.out.println(arg);

            if (arg instanceof Account) {
//                downcast and print Account specific stuff
                Account theAccount = (Account) arg;
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }

}
