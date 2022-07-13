package com.example.BankAccPrototype;

import exceptions.InsufficientBalanceException;

import java.math.BigDecimal;

public interface BankAcc {
    public void deposit(BigDecimal amount);
    public void withdraw(BigDecimal amount) throws InsufficientBalanceException;

    public boolean checkBalance(BigDecimal amount);

}
