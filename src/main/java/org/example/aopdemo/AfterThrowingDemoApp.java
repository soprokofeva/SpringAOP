package org.example.aopdemo;

import org.example.aopdemo.aspect.MyDemoLoggingAspect;
import org.example.aopdemo.dao.AccountDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    private static final Logger MAIN_LOG = LoggerFactory.getLogger(AfterThrowingDemoApp.class);

    public static void main(String[] args) {

//        read spring java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //        get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);


        List<Account> accounts = null;
        try {
//            add a boolean flag to simulate exceptions
            boolean tripWire = true;
            accounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            MAIN_LOG.error("\n\nMain Program ... caught exception: " + e);
        }

        System.out.println(accounts);

//        close the context
        context.close();
    }
}
