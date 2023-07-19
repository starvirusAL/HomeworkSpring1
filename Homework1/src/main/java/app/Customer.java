package app;

import app.DAO.Identifable;
import app.custom.RandomNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Customer implements Identifable {
    private int id;
    private String name;
    private String email;

    private String age;
    private List<Account> accounts;

    public void addAccounts(Account account){
        accounts.add(account);
    }
    public Account getAccountList(int id){
        return accounts.get(id);
    }

    Customer(){

    }

    Customer(Integer id, String name, String email, String age, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return String.format("Id: %s Name: %s, Age: %s E-mail: %s, Acc: %s",id, name, age, email, accounts);
    }

    @Override
    public int id() {
        return RandomNumber.RandomId();
    }
}
