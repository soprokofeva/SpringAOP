package org.example.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addSillyMember() {
        System.out.println(getClass() + ": DONG DB WORK: ADDING AN MEMBERSHIP ACCOUNT");
        return true;
    }

}
