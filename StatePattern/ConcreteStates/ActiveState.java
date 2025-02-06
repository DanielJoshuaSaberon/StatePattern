package StatePattern.ConcreteStates;

import StatePattern.Context.AccountController;
import StatePattern.StateInterface.AccountState;

public class ActiveState implements AccountState {

    @Override
    public void deposit(AccountController account, double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposit successful!");
        System.out.println(account);
    }

    @Override
    public void withdraw(AccountController account, double amount) {
        account.setBalance(account.getBalance() - amount);
        System.out.println("Withdrawal successful!");
        System.out.println(account);
    }

    @Override
    public void activate(AccountController account) {
        System.out.println("This account is already activated");
    }

    @Override
    public void suspend(AccountController account) {
        account.setAccountState(new SuspendedState());
        System.out.println("This account is now suspended");
    }

    @Override
    public void close(AccountController account) {
        account.setAccountState(new ClosedState());
        System.out.println("This account is now closed");
    }
}
