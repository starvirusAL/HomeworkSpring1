package app;

import app.DAO.DAO;
import app.DAO.DAOLinkedList;
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
    DAO<Account> daoAccList = new DAOLinkedList<>();
    private int id;
    private String name;
    private String email;

    private int age;
    private List<Account> accounts = daoAccList.findAll();

    public void addAccounts(Account account) {

        daoAccList.save(account);
    }

    public Account getAccountList(int id) {
        return daoAccList.getOne(id);
    }

    Customer() {

    }

    Customer(Integer id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;

    }

    @Override
    public String toString() {
        return String.format("Id: %s Name: %s, Age: %s E-mail: %s, Acc: %s", id, name, age, email, accounts);
    }

    @Override
    public int id() {
        return RandomNumber.RandomId();
    }
}
