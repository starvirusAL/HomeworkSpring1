package app;

import app.DAO.DAO;
import app.DAO.DAOLinkedList;

import java.util.List;

public class CustomerController {

    DAO<Customer> daoListC = new DAOLinkedList<>();
    DAO<Account> daoListA = new DAOLinkedList<>();

    public Customer getCustomerId(int id) {
        return daoListC.getOne(id);
    }

    public List<Customer> getAllCustomer() {
        return daoListC.findAll();
    }

    public void createNewCustomer( String name, String email, String age) {
        daoListC.save(new Customer(daoListC.daoSize(), name, email, age, List.of(new Account(Currency.EUR))));
    }
//доработать
    public Customer refactorCustomer(Customer customer) {

        return new Customer();
    }

    public void deleteCustomer(int id) {
        daoListC.deleteById(id);
    }

    public void createAccount(Customer customer) {
        daoListA.save(new Account(customer, Currency.CHF));
        customer.addAccounts(daoListA.getOne(0));
    }

    public void deleteAccount(Customer customer, int id) {
        customer.getAccounts().remove(id);
    }


}
