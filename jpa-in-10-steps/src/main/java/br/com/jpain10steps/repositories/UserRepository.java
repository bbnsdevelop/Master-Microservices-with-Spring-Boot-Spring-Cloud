package br.com.jpain10steps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jpain10steps.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
