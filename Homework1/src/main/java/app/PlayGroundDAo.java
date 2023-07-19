package app;

import app.custom.RandomNumber;

public class PlayGroundDAo {
    public static void main(String[] args) {
CustomerController cc = new CustomerController();
Customer c1 = new Customer();

        cc.createNewCustomer("Alex", "@", String.valueOf(12));
        cc.daoListC.save(c1);
         cc.createAccount(c1) ;
        System.out.println();
        System.out.println(cc.daoListC.findAll());

        System.out.println(RandomNumber.RandomId());



    }
}
