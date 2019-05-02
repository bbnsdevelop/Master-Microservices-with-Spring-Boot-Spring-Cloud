package br.com.jpain10steps.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.jpain10steps.model.User;

@Repository
@Transactional
public class UserDaoService {
	
	@PersistenceContext
	private EntityManager entityManager;

	public long insertUser(User user) {
		entityManager.persist(user);
		return user.getId();
	}
}
