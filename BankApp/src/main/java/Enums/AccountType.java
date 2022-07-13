package Enums;

public enum AccountType {
    SAVINGS("Savings"),
    CURRENT("Current"),
    FIXED_DEPOSIT("FD");

    public String value;
    AccountType(String value) {
        this.value = value;
    }
}
