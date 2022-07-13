package com.example.BankAccPrototype;

import java.math.BigDecimal;
import Enums.AccountType;
import exceptions.*;


public abstract class Account implements BankAcc{
    private String ownerName;
    private BigDecimal balance;
    private AccountType AccType;

    private BigDecimal minBalance = BigDecimal.valueOf(0);
    private BigDecimal overDraft = BigDecimal.valueOf(0);


    public Account(String ownerName, BigDecimal balance, AccountType accType, BigDecimal minBalance) throws MinBalanceException {
        this.ownerName = ownerName;
        this.minBalance = minBalance;
        try{
            if(balance.compareTo(this.minBalance) >= 0){
                this.balance = balance;
            }
            else throw new MinBalanceException("Minimum balance required!!");
        }
        catch (MinBalanceException e){
            e.getMessage();
            throw new MinBalanceException("Minimum balance required!!");
        }
        this.AccType = accType;
    }

    @Override
    public void deposit(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    @Override
    public void withdraw(BigDecimal amount) throws InsufficientBalanceException {
        try{
            if(checkBalance(amount)){
                this.balance = this.balance.subtract(amount);
            }
            else throw new InsufficientBalanceException("Insufficient Balance!!");
        }
        catch (InsufficientBalanceException e){
            e.getMessage();
            throw new InsufficientBalanceException("Insufficient Balance!!");
        }


    }

    @Override
    public boolean checkBalance(BigDecimal amount){
        if(this.AccType == AccountType.CURRENT){
            BigDecimal temp = this.balance.add(this.overDraft);
            return temp.compareTo(amount) >= 0;
        }
        return this.balance.compareTo(amount) >= 0;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountType getAccType() {
        return AccType;
    }

    public void setMinBalance(BigDecimal bal){
        this.minBalance = bal;
    }

    public void setOverDraft(BigDecimal amt){
        this.overDraft = amt;
    }
}
