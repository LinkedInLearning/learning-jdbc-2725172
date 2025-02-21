package com.loogibot.lil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.loogibot.lil.data.dao.ServiceDao;
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
    }
}
