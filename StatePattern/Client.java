package StatePattern;

import StatePattern.Context.AccountController;

public class Client {
    public static void main(String[]args){
        AccountController account = new AccountController("22-13207-591", 1500.00);

        account.deposit(143.00);
        account.withdraw(220.00);
        account.suspend();
        account.deposit(350.00);
        account.activate();
        account.close();
        account.withdraw(2000.00);
    }
}
