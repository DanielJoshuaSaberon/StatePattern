package StatePattern.ConcreteStates;

import StatePattern.Context.AccountController;
import StatePattern.StateInterface.AccountState;

public class ClosedState implements AccountState {

    @Override
    public void deposit(AccountController account, double amount) {
        System.out.println("Depositing is not allowed, Closed account");

    }

    @Override
    public void withdraw(AccountController account, double amount) {
        System.out.println("Withdrawal is not allowed, Closed account");
    }

    @Override
    public void activate(AccountController account) {
        System.out.println("This account is already closed");
    }

    @Override
    public void suspend(AccountController account) {
        System.out.println("This account is already closed");
    }

    @Override
    public void close(AccountController account) {
        System.out.println("This account is already closed");
    }
}
