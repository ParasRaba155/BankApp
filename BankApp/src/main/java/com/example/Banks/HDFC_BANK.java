package com.example.Banks;

import Enums.AccountType;
import com.example.BankAccPrototype.Account;
import com.example.BankAccPrototype.BankAcc;
import exceptions.InsufficientBalanceException;
import exceptions.MinBalanceException;

import java.math.BigDecimal;

public class HDFC_BANK extends Account implements BankAcc {



    public HDFC_BANK(String ownerName, BigDecimal balance, AccountType accType, BigDecimal minBalance) throws MinBalanceException {
        super(ownerName, balance, accType, minBalance);
        super.setMinBalance(BigDecimal.valueOf(5000));
        super.setOverDraft(this.getBalance().multiply(BigDecimal.valueOf(0.2)));
    }



    @Override
    public void withdraw(BigDecimal amount) throws InsufficientBalanceException {
        super.withdraw(amount);
        System.out.println("Withdrawn from HDFC Bank");
    }

    @Override
    public void deposit(BigDecimal amount) {
        super.deposit(amount);
        System.out.println("Deposited in HDFC Bank");
    }


    @Override
    public void setOverDraft(BigDecimal amt) {
        super.setOverDraft(amt);
    }
}
