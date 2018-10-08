package com.spring.rest.service;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.dao.UserDao;
import com.spring.rest.exception.UserNotFoundException;
import com.spring.rest.model.User;

@Service
public class UserService{
	private static final Logger LOGGER =LoggerFactory.getLogger(UserService.class);
	private static final String CLASSNAME = "UserService";
	@Autowired
	private UserDao userDao;
	
	
	public List<User> getAllUsers() throws UserNotFoundException{
		LOGGER.info("Inside Service::"+ CLASSNAME + " Method:: getAllUsers()" );
		List<User> resultList = new ArrayList<>();
		for(User user : userDao.findAll()) {
			LOGGER.info(user.toString());
			resultList.add(user);
		}
	return resultList;
		
	}
	public User getUser(Long id) throws UserNotFoundException {
		LOGGER.info("Inside Service::"+ CLASSNAME + " Method:: getUser()" );
		
		return userDao.findById(id).get();
	}
	public void addUser(User b)  throws UserNotFoundException {
		//userList.add(b);
		System.out.println(b.toString());
		userDao.save(b);
	}
	public void deleteUser(Long uid)  throws UserNotFoundException {
		//userList.add(b);
		//System.out.println(b.toString());
		userDao.deleteById(uid);
	}
	
}
