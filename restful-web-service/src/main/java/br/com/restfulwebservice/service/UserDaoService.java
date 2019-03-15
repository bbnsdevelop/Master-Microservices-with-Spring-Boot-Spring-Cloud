package br.com.restfulwebservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.restfulwebservice.entities.Post;
import br.com.restfulwebservice.entities.User;
import br.com.restfulwebservice.repositories.PostRepository;
import br.com.restfulwebservice.repositories.UserRepository;
import br.com.restfulwebservice.service.businessException.UserNotFoundException;

@Component
public class UserDaoService {

	private static Logger log = LoggerFactory.getLogger(UserDaoService.class);

	private static List<User> users = new ArrayList<>();
	private static int userCount = 3;
	private User user;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	static {
		users.add(new User(1, "Adam", LocalDate.now()));
		users.add(new User(2, "Eve", LocalDate.now()));
		users.add(new User(3, "Jack", LocalDate.now()));

	}

	public List<User> findAllRepository() {
		return userRepository.findAll();
	}

	public List<User> findAll() {
		log.info("find all users");
		return users;
	}

	public User saveRepository(User user) {
		log.info("save an user {}", user.getName());
		User userSaved = userRepository.save(user);
		return userSaved;
	}

	public User save(User user) {
		log.info("save an user {}", user.getName());
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		log.info("find user by id {}", id);
		this.user = null;
		users.stream().filter(u -> u.getId() == id).forEach(u -> {
			this.user = new User(u.getId(), u.getName(), u.getBirthDate());
		});
		if (this.user == null) {
			throw new UserNotFoundException("id - " + id);
		}
		return this.user;
	}

	public User findOneRepository(int id) {
		log.info("find user by id {}", id);
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id - " + id);
		}
		return user.get();
	}

	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		throw new UserNotFoundException("id não encontrado: " + id);

	}

	public void deleteByIdRepository(int id) {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			throw new UserNotFoundException("id não encontrado: " + id);
		}

	}

	public List<Post> findPostByUserId(int id) {
		log.info("find user by id {}", id);
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id - " + id);
		}
		return user.get().getPosts();
	}

	public Post savePostRepository(@Valid Post post, int id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User id ->" + id+" not found");
		}
		post.setUser(userOptional.get());
		
		Post postSaved = postRepository.save(post);
		return postSaved;
	}
}
