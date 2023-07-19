package app;

import app.DAO.Identifable;
import app.custom.RandomNumber;
import lombok.Getter;

@Getter
public class Account implements Identifable {
    private int id;
    private String number = RandomNumber.randomDiceNumber();
    private Currency currency;
    private Double balance =0.0;
    private Customer customer;
    Account(Currency currency ) {
        this.currency = currency;

    }

    Account(Customer customer, Currency currency) {
        this.currency = currency;
        this.customer = customer;
    }

    public Double getBalance() {
        return this.balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

    public String getAccountNumber (){
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int id() {
        return this.id++;
    }

    @Override
    public String toString() {
        return String.format("Cur:%s, Num:%s", currency, number);
    }
}
