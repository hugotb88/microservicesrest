package com.mastermicroservices.rest.webservices.microservicesrest.daos;

import com.mastermicroservices.rest.webservices.microservicesrest.pojos.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
