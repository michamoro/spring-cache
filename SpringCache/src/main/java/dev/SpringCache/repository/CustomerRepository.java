package dev.SpringCache.repository;

import dev.SpringCache.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Transactional(readOnly = true)
    @Override
    List<Customer> findAll();
}
