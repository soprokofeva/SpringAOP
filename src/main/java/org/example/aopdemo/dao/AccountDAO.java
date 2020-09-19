package org.example.aopdemo.dao;

import org.example.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    private String name;
    private String serviceCode;

    public List<Account> findAccounts(boolean tripWire) {

//        simulate the exception
        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> accounts = new ArrayList<>();

//        create sample accounts
        Account tmp1 = new Account("John", "Silver");
        Account tmp2 = new Account("Madhu", "Platinum");
        Account tmp3 = new Account("Luca", "Gold");

        accounts.add(tmp1);
        accounts.add(tmp2);
        accounts.add(tmp3);

        return accounts;
    }

    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + ": DONG DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": getName()");

        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
