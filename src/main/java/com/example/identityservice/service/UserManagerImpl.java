package com.example.identityservice.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.identityservice.dao.UserDAO;
import com.example.identityservice.dto.UserDto;
import com.example.identityservice.dto.UserDtoResponse;
import com.example.identityservice.entities.User;
import com.example.identityservice.exception.IMSException;
import com.example.identityservice.manager.UserManager;
import com.example.identityservice.util.APIListResponse;

@Service
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserDAO userDao;

	@Override
	public UserDtoResponse createUser(UserDto userDto) throws IMSException {
		User user = userDao.createUser(userDto);
		return new UserDtoResponse(user);

	}

	@Override
	public APIListResponse getAllUser(Integer startIndex, Integer count, String sortBy, String sortOrder)
			throws IMSException {
		APIListResponse response = new APIListResponse();
		Set<UserDtoResponse> data = new LinkedHashSet<UserDtoResponse>();
		List<User> user = userDao.getAllUser(startIndex, count, sortBy, sortOrder);
		for (User usr : user) {
			UserDtoResponse dtoResponse = new UserDtoResponse(usr);
			data.add(dtoResponse);
		}
		response.setResources(data);
		response.setTotalResults(data.size());
		return response;
	}

	@Override
	public UserDtoResponse getUser(long userId) throws IMSException {
		User user = userDao.getUser(userId);
		return new UserDtoResponse(user);
	}

	@Override
	public UserDtoResponse updateUser(long userId, UserDto updateDto) throws IMSException {
		User user = userDao.updateUser(userId, updateDto);
		return new UserDtoResponse(user);
	}

	@Override
	public void deleteUser(long userId) throws IMSException {
		userDao.deleteUser(userId);

	}

}
