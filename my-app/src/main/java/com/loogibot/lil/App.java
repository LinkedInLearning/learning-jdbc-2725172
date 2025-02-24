package com.loogibot.lil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.loogibot.lil.data.dao.CustomerDao;
import com.loogibot.lil.data.dao.ServiceDao;
import com.loogibot.lil.data.entity.Customer;
import com.loogibot.lil.data.entity.Service;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ServiceDao serviceDao = new ServiceDao();
        List<Service> services = serviceDao.getAll();
        System.out.println("**** SERVICES ****");
        System.out.println("\n *** GET_ALL ***");
        services.forEach(System.out::println);

        Optional<Service> service = serviceDao.getOne(services.get(0).getServiceId());
        System.out.println("\n *** GET ONE ***\n" + service.get());

        Service newService = new Service();
        newService.setName("FooBarBaz" + System.currentTimeMillis());
        newService.setPrice(new BigDecimal(4.35));
        newService = serviceDao.create(newService);
        System.out.println("\n *** CREATE ***\n" + newService);

        newService.setPrice(new BigDecimal(13.45));
        newService = serviceDao.update(newService);
        System.out.println("\n *** UPDATE *** \n" + newService);

        serviceDao.delete(newService.getServiceId());
        System.out.println("\n *** DELETE *** \n");

        //

        CustomerDao customerDao = new CustomerDao();
        List<Customer> customers = customerDao.getAll();
        System.out.println("**** SERVICES ****");
        System.out.println("\n *** GET_ALL ***");
        customers.forEach(System.out::println);

        Optional<Customer> customer = customerDao.getOne(customers.get(0).getCustomerId());
        System.out.println("\n *** GET ONE ***\n" + service.get());

        Customer newCustomer = new Customer();
        newCustomer.setFirst_name("Joey" + System.currentTimeMillis());
        newCustomer.setLast_name("Castillo" + System.currentTimeMillis());
        newCustomer.setEmail("Joey@Castillo.com" + System.currentTimeMillis());
        newCustomer.setPhone("5552746" + System.currentTimeMillis());
        
        newCustomer = customerDao.create(newCustomer);
        System.out.println("\n *** CREATE ***\n" + newCustomer);

        newCustomer = customerDao.update(newCustomer);
        System.out.println("\n *** UPDATE *** \n" + newCustomer);

        customerDao.delete(newCustomer.getCustomerId());
        System.out.println("\n *** DELETE *** \n");

    }
}
