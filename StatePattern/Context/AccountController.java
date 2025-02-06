package StatePattern.Context;

import StatePattern.ConcreteStates.ActiveState;
import StatePattern.StateInterface.AccountState;

public class AccountController {
    private String accountNumber;
    private double balance;
    private AccountState accountState;

    public AccountController(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.accountState = new ActiveState();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountState getAccountState() {
        return accountState;
    }

    public void setAccountState(AccountState accountState) {
        this.accountState = accountState;
    }
    public void deposit(double amount) {
        accountState.deposit(this, amount);
    }

    public void withdraw(double amount) {
        accountState.withdraw(this, amount);
    }

    public void suspend() {
        accountState.suspend(this);
    }

    public void activate() {
        accountState.activate(this);
    }

    public void close() {
        accountState.close(this);
    }

    @Override
    public String toString(){
        return "Account Number: " + accountNumber +
                "\nBalance: " + balance;
    }
}
