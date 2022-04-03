package com.javastart;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    boolean existsByUsername(String username);
}
