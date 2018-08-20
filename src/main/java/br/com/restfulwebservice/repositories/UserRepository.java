package br.com.restfulwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restfulwebservice.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
