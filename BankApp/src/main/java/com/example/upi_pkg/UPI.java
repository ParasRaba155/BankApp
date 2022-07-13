package com.example.upi_pkg;

import com.example.BankAccPrototype.Account;
import exceptions.InsufficientBalanceException;
import exceptions.SameAccException;

import java.math.BigDecimal;

public class UPI {
    private final String upiId;
    private final Account account;

    public UPI(String upiId, Account account) {
        this.upiId = upiId;
        this.account = account;
    }

    public void transfer(BigDecimal amount, UPI destination) throws SameAccException, InsufficientBalanceException {
        if(this == destination){
            throw new SameAccException("Can not transfer to same account");
        }
        else{
            this.account.withdraw(amount);
            destination.account.deposit(amount);
        }
    }
}
