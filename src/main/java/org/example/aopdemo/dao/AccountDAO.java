package org.example.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ": DONG DB WORK: ADDING AN ACCOUNT");
    }
}
