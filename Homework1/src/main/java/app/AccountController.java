package app;

public class AccountController {
    public void replenishTheBalance(Account account, double valueM) {
        account.setBalance(account.getBalance() + valueM);

    }

    public boolean withdrawBalance(Account account, double valueM) {
        if (account.getBalance() >= valueM) {
            account.setBalance(account.getBalance() - valueM);
            return true;
        } else {
            return false;
        }

    }

    public boolean transferMoney(Account account1, Account account2, double valueM) {
        if (account1.getBalance() >= account2.getBalance()) {
            account2.setBalance(account2.getBalance() + valueM);
            account1.setBalance(account1.getBalance() - valueM);
            return true;
        } else {
            return false;
        }

    }
}
