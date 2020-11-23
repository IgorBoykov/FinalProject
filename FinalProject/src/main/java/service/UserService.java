package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dao.UserRepository;
import domain.User;
import domain.UserRole;

@Service
public class UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {
		logger.info("Save user {} - " + user);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setPassword(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
		user.setRole(UserRole.USER);
		userRepository.save(user);
	}

	public User findByEmail(String email) {
		logger.info("Find user by email - " + email);
		return userRepository.findByEmail(email).get();
	}
	
	public User findById(Integer id) {
		logger.info("Find user by id - " + id);
		return userRepository.findById(id).get();
	}
}
