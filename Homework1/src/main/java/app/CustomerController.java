package app;

import app.DAO.DAO;
import app.DAO.DAOLinkedList;

import java.util.List;

public class CustomerController {

    DAO<Customer> daoListC = new DAOLinkedList<>();


    public Customer getCustomerId(int id) {
        return daoListC.getOne(id);
    }

    public List<Customer> getAllCustomer() {
        return daoListC.findAll();
    }

    public void createNewCustomer( String name, String email, String age) {
        daoListC.save(new Customer(daoListC.daoSize(), name, email, age));
    }
//доработать
    public Customer refactorCustomer(Customer customer) {

        return new Customer();
    }

    public void deleteCustomer(int id) {
        daoListC.deleteById(id);
    }

    public void createAccount(Customer customer) {

        customer.addAccounts(new Account(Currency.CHF));
    }

    public void deleteAccount(Customer customer, int id) {
        customer.daoAccList.deleteById(id);
    }


}
