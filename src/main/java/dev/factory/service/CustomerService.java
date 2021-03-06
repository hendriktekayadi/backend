package dev.factory.service;

import dev.factory.dao.CustomerDao;
import dev.factory.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Transactional
    public Customer createCustomer(Customer customer)  {
        customerDao.save(customer);
        return customer;
    }

    @Transactional
    public List<Customer> getCustomers()  {
        return customerDao.findAll();
    }

    @Transactional
    public Customer getCustomer(String code)  {
        return customerDao.findByCode(code);
    }

    @Transactional
    public String deleteCustomer(String code)  {
        Customer customer = customerDao.findByCode(code);
        customerDao.delete(customer);
        return "Success delete of customer";
    }

}
