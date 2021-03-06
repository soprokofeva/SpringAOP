package org.example.aopdemo;

import org.example.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

//        read spring java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

//        get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

//        call the business method
        theAccountDAO.addAccount();

        theAccountDAO.addAccount();

//        close the context
        context.close();
    }
}
