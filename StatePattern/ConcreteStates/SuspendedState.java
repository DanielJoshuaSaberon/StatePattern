package StatePattern.ConcreteStates;

import StatePattern.Context.AccountController;
import StatePattern.StateInterface.AccountState;

public class SuspendedState implements AccountState {

    @Override
    public void deposit(AccountController account, double amount) {
        System.out.println("Depositing is not allowed");

    }

    @Override
    public void withdraw(AccountController account, double amount) {
        System.out.println("Withdrawal is not allowed");
    }

    @Override
    public void activate(AccountController account) {
        account.setAccountState(new ActiveState());
        System.out.println("This account is now activated");
    }

    @Override
    public void suspend(AccountController account) {
        System.out.println("This account is already suspended");
    }

    @Override
    public void close(AccountController account) {
        account.setAccountState(new ClosedState());
        System.out.println("This account is now closed");
    }
}
