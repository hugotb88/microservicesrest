package com.mastermicroservices.rest.webservices.microservicesrest.daos;

import com.mastermicroservices.rest.webservices.microservicesrest.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
