package com.maximodev.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.maximodev.workshopmongo.domain.User;
import java.util.List;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User getUserById(String id);
    
}
