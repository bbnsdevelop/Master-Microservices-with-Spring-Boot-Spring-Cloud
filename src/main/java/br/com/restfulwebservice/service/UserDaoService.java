package br.com.restfulwebservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import br.com.restfulwebservice.entities.User;

@Component
public class UserDaoService {

	private static Logger log = LoggerFactory.getLogger(UserDaoService.class);
	
	private static List<User> users = new ArrayList<>();
	private static int userCount = 3;
	private User user;
	
	static {
		users.add(new User(1, "Adam", LocalDate.now()));
		users.add(new User(2, "Eve", LocalDate.now()));
		users.add(new User(3, "Jack", LocalDate.now()));
		
	}
	
	public List<User> findAll(){
		log.info("find all users");
		return users;
	}
	
	public User save(User user) {
		log.info("save an user {}", user.getName() );
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	public User findOne(int id) {
		log.info("find user by id {}", id);
		users.stream().filter(u -> u.getId() == id).forEach(u ->{
			this.user = new User(u.getId(), u.getName(), u.getBirthDate());
		});
		return user;
	}
}
