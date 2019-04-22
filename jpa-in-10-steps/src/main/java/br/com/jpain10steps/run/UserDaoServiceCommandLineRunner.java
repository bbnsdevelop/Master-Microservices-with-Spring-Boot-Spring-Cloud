package br.com.jpain10steps.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.jpain10steps.model.User;
import br.com.jpain10steps.repositories.UserRepository;
import br.com.jpain10steps.service.UserDaoService;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	
	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {

		User user = new User("Bruno", "Admin");
		long insertuser = userDaoService.insertUser(user);
		log.info("New user is Created: " + user);

		User user2 = new User("Bruno", "Admin");		
		user2 = userRepository.save(user2);
		log.info("New user is Created with jpaRepository: " + user2);
	}

}
