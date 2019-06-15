package com.example.identityservice.manager;

import com.example.identityservice.dto.UserDto;
import com.example.identityservice.dto.UserDtoResponse;
import com.example.identityservice.exception.IMSException;
import com.example.identityservice.util.APIListResponse;

public interface UserManager {

	UserDtoResponse createUser(UserDto userDto) throws IMSException;

	APIListResponse getAllUser(Integer startIndex, Integer count, String sortBy, String sortOrder) throws IMSException;

	UserDtoResponse getUser(long userId) throws IMSException;

	UserDtoResponse updateUser(long userId, UserDto updateDto) throws IMSException;

	void deleteUser(long userId) throws IMSException;

}
