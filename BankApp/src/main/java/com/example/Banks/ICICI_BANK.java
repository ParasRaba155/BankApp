package com.example.Banks;

import Enums.AccountType;
import com.example.BankAccPrototype.Account;
import com.example.BankAccPrototype.BankAcc;
import exceptions.InsufficientBalanceException;
import exceptions.MinBalanceException;

import java.math.BigDecimal;

public class ICICI_BANK extends Account implements BankAcc {

    private BigDecimal minBalance = BigDecimal.valueOf(1000);
    public ICICI_BANK(String ownerName, BigDecimal balance, AccountType accType, BigDecimal minBalance) throws MinBalanceException {
        super(ownerName, balance, accType,minBalance);
        super.setMinBalance(BigDecimal.valueOf(1000));
        super.setOverDraft(this.getBalance().multiply(BigDecimal.valueOf(0.3)));
    }

    BigDecimal overDraft = this.getBalance().multiply(BigDecimal.valueOf(0.1));

    @Override
    public void withdraw(BigDecimal amount) throws InsufficientBalanceException {
        super.withdraw(amount);
        System.out.println("Withdrawn from ICICI Bank");
    }

    @Override
    public void deposit(BigDecimal amount) {
        super.deposit(amount);
        System.out.println("Deposited in ICICI Bank");
    }

    @Override
    public void setMinBalance(BigDecimal bal) {
        super.setMinBalance(bal);
    }

    @Override
    public void setOverDraft(BigDecimal amt) {
        super.setOverDraft(amt);
    }
}
