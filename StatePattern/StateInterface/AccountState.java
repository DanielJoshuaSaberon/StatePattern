package StatePattern.StateInterface;

import StatePattern.Context.AccountController;

public interface AccountState {
    void deposit(AccountController account, double amount);
    void withdraw(AccountController account, double amount);
    void activate(AccountController account);
    void suspend(AccountController account);
    void close(AccountController account);
}
