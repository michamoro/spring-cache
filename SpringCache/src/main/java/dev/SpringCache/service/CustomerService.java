package dev.SpringCache.service;

import dev.SpringCache.dto.CustomerDTO;
import dev.SpringCache.entity.Customer;
import dev.SpringCache.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Cacheable("customers")
    public List<CustomerDTO> all() {
        List<Customer> cList = this.customerRepository.findAll();
        List<CustomerDTO> customers = new ArrayList<>();
        cList.forEach(c -> {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerName(c.getCustomerName());
            customerDTO.setId(c.getId());
            customers.add(customerDTO);
        });
        return customers;
    }

    @CacheEvict(value = "customers", allEntries = true)
    public void save(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setCustomerName(dto.getCustomerName());
        customerRepository.save(customer);
    }
}
