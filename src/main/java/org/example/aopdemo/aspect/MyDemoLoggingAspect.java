package org.example.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.aopdemo.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    private final Logger LOG = LoggerFactory.getLogger(MyDemoLoggingAspect.class);

    @Before("org.example.aopdemo.aspect.UtilAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinpoint) {
        LOG.info("Executing @Before advice on method");

//        display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinpoint.getSignature();
        System.out.println("Method: " + methodSignature);
//        display method arguments

//        get args
        Object[] args = theJoinpoint.getArgs();

//        loop the args
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

    @AfterReturning(
            pointcut = "execution(* org.example.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinpoint, List<Account> result) {

//        print out which method we are advising on
        String method = theJoinpoint.getSignature().toShortString();
        LOG.info("Executing @AfterReturning on method: " + method);

//        print out the results of the method call
        LOG.info("result is: " + result);

//        post-process the data ... modifying it :)

//        convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        //        print out the results of the method call
        LOG.info("result is: " + result);
    }

    @AfterThrowing(pointcut = "execution(* org.example.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc")
    public void afterThrowingFindAccountAdvice(
            JoinPoint theJoinPoint, Throwable exc) {

//        print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        LOG.info("Executing @AfterThrowing on method: " + method);

//        log the exception
        LOG.error("The exception is: " + exc);
    }

    @After("execution(* org.example.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        //        print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        LOG.debug("Executing @After (finally) on method: " + method);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

//        loop through accounts
        for (Account tmpAccount : result) {
//        get uppercase version of name
            String theUpperName = tmpAccount.getName().toUpperCase();

//        update the name on the account
            tmpAccount.setName(theUpperName);
        }
    }

}
