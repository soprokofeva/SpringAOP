package org.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("org.example.aopdemo.aspect.UtilAopExpressions.forDaoPackageNoGetterSetter()")
    public void loadToCloudAsync() {
        System.out.println("\n=====>>> Logging to cloud in async fashion");
    }

}
