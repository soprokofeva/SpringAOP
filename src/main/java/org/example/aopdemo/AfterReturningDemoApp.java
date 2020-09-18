package org.example.aopdemo;

import org.example.aopdemo.dao.AccountDAO;
import org.example.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {

//        read spring java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //        get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);


        List<Account> accounts = theAccountDAO.findAccounts();

        System.out.println(accounts);

//        close the context
        context.close();
    }

}
