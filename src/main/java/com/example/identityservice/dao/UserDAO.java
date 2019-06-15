package com.example.identityservice.dao;

import java.util.List;

import com.example.identityservice.dto.UserDto;
import com.example.identityservice.entities.User;
import com.example.identityservice.exception.IMSException;

public interface UserDAO {

	User createUser(UserDto userDto) throws IMSException;

	List<User> getAllUser(Integer startIndex, Integer count, String sortBy, String sortOrder) throws IMSException;

	User getUser(long userId) throws IMSException;

	User updateUser(long userId, UserDto updateDto) throws IMSException;

	void deleteUser(long userId) throws IMSException;

}
