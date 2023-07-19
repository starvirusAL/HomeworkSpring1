package app;

import app.custom.RandomNumber;

public class PlayGroundDAo {
    public static void main(String[] args) {
CustomerController cc = new CustomerController();
Customer c1 = new Customer();

        cc.createNewCustomer("Alex", "@", String.valueOf(12));
cc.daoListC.getOne(0).addAccounts(new Account(Currency.CHF));
        c1.addAccounts(new Account(Currency.CHF));
        cc.daoListC.save(c1);
        System.out.println(cc.daoListC.findAll());

        System.out.println(RandomNumber.RandomId());



    }
}
