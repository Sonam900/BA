package com.sonam.service.impl;

import java.util.List;
import java.util.Optional;

//import com.sonam.utils.EmailService;
//import com.sonam.utils.OtpGenerator;
//import com.sonam.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.sonam.Repo.UserRepo;
import com.sonam.entity.User;
import com.sonam.exceptions.EmailAlreadyExistsException;
import com.sonam.exceptions.IncorrectPasswordException;
import com.sonam.exceptions.ResourceNotFoundException;
//import com.sonam.exceptions.IncorrectPasswordException;
import com.sonam.payLoad.UserDto;
import com.sonam.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userrepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	/*
	 * @Autowired private EmailService emailService;
	 */

	@Override
	public User createUser(UserDto userDto) {

		if (userrepo.existsByEmail(userDto.getEmail())) {
			throw new EmailAlreadyExistsException("Email is already registered");
		}

		User newUser = new User();

		newUser.setUid(userDto.getUid());
		newUser.setEmail(userDto.getEmail());
		newUser.setPassword(userDto.getPassword());
		newUser.setName(userDto.getName());
		newUser.setAbout(userDto.getAbout());

		return userrepo.save(newUser);
	}

	@Override
	public List<User> getAllUser() {
		List<User> UserRecord = userrepo.findAll();
		return UserRecord;
	}

	@Override
	public boolean updateUser(long uid, UserDto updatedUserData) {
		Optional<User> optionalUser = userrepo.findById(uid);

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();

			// Update only the fields that are not null in the UserDto
			if (updatedUserData.getEmail() != null) {
				// You might want to add validation or additional logic here
				user.setEmail(updatedUserData.getEmail());
			}
			if (updatedUserData.getPassword() != null) {
				// You should hash the password before updating it
				user.setPassword(updatedUserData.getPassword());
			}
			if (updatedUserData.getName() != null) {
				user.setName(updatedUserData.getName());
			}
			if (updatedUserData.getAbout() != null) {
				user.setAbout(updatedUserData.getAbout());
			}

			// Save the updated user to the database
			userrepo.save(user);

			return true; // Update successful
		} else {
			return false; // User with the given uid not found
		}
	}

	@Override
	public boolean deleteUser(long uid) {
		User user = userrepo.findById(uid).get();
		if (user != null) {
			userrepo.delete(user);
			return true;
		} else
			return false;
	}

	@Override
	public User getUserById(long uid) {
		Optional<User> optionalUser = userrepo.findById(uid);
		return optionalUser.orElse(null);
	}

//	@Override
//	public String userLogin(String name, String password) {
//		User existinguser = userrepo.findByName(name)
//				.orElseThrow(() -> new ResourceNotFoundException("User not found with the name: " + name));
//		if (existinguser.getPassword() != null) {
//			if (passwordEncoder.matches(password, existinguser.getPassword())) {
//				return "Logged in";
//			} else {
//				throw new IncorrectPasswordException("Password did not match");
//			}
//		}
//		return "OTP not verified";
//	}

	@Override
	public String forgotPassword(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String userLogin(String name, String password) {
		User existingUser = userrepo.findByName(name)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with the name: " + name));
		if (existingUser.getPassword() != null) {
			if (passwordEncoder.matches(password, existingUser.getPassword())) {
				return "Logged in";
			} else {
				throw new IncorrectPasswordException("Password did not match");
			}
		}
		return "Unable to login";
	}

}
