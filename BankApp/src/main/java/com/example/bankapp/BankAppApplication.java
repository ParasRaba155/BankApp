package com.example.bankapp;

import Enums.AccountType;
import com.example.Banks.HDFC_BANK;
import com.example.Banks.ICICI_BANK;
import com.example.upi_pkg.*;
import exceptions.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class BankAppApplication {

    public static void main(String[] args) throws MinBalanceException, InsufficientBalanceException, SameAccException {

        HDFC_BANK Acc1 = new HDFC_BANK("Paras", BigDecimal.valueOf(3000), AccountType.SAVINGS,
                BigDecimal.valueOf(1000));
        ICICI_BANK Acc2 = new ICICI_BANK("Vatsal",BigDecimal.valueOf(5000),AccountType.CURRENT,
                BigDecimal.valueOf(1000));

        UPI upiID1 = new UPI("123456", Acc1);
        UPI upiID2 = new UPI("456123", Acc2);

        System.out.println(Acc1.getBalance());
        System.out.println(Acc2.getBalance());

        upiID2.transfer(BigDecimal.valueOf(5500),upiID1);


        System.out.println(Acc1.getBalance());
        System.out.println(Acc2.getBalance());

        SpringApplication.run(BankAppApplication.class, args);
    }

}
