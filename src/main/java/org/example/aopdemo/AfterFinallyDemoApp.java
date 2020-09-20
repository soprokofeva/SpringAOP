package org.example.aopdemo;

import org.example.aopdemo.dao.AccountDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {

    private static final Logger MAIN_FINALLY_LOG = LoggerFactory.getLogger(AfterThrowingDemoApp.class);

    public static void main(String[] args) {

//        read spring java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //        get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);


        List<Account> accounts = null;
        try {
//            add a boolean flag to simulate exceptions
            boolean tripWire = false;
            accounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            MAIN_FINALLY_LOG.error("\n\nMain Program ... caught exception: " + e);
        }

        System.out.println(accounts);

//        close the context
        context.close();
    }
}
