package com.example.identityservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.identityservice.dto.UserDto;
import com.example.identityservice.dto.UserDtoResponse;
import com.example.identityservice.exception.IMSException;
import com.example.identityservice.manager.UserManager;
import com.example.identityservice.util.APIListResponse;
import com.example.identityservice.util.Utils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.example.identityservice.common.Constants;

@RestController
@Api(tags = "identity service", value = "identity service")
@RequestMapping(Constants.IDENTITY_SERVICE_ENDPOINT)
public class UserController {

	@Autowired
	private UserManager manager;

	@RequestMapping(value = "/test/", method = RequestMethod.GET)
	public String display() {
		return "Welcome to the identity service";
	}

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	@ApiOperation(value = "Create New User", notes = "return creation status", response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 401, message = "Authentication credentials are required") })
	@ResponseBody
	public ResponseEntity<?> createUser(@RequestBody UserDto userDto) throws Exception {
		try {
			UserDtoResponse dtoResponse = manager.createUser(userDto);
			return new ResponseEntity<UserDtoResponse>(dtoResponse, HttpStatus.CREATED);
		} catch (IMSException e) {
			return Utils.getErrorResponseEntity(e.getError().getErrorDescr(),
					HttpStatus.valueOf(e.getError().getErrorCode()));
		}
	}

	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	@ApiOperation(value = "Get All Users in the system", notes = "Get all notes", response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 401, message = "Authentication credentials are required") })
	@ResponseBody
	public ResponseEntity<?> getAllUser(
			@ApiParam(value = Constants.PARAM_START_INDEX, required = false) @RequestParam(value = Constants.PARAM_START_INDEX, required = false) Integer startIndex,
			@ApiParam(value = Constants.PARAM_PAGE_SIZE, required = false) @RequestParam(value = Constants.PARAM_PAGE_SIZE, required = false) Integer count,
			@ApiParam(value = Constants.PARAM_SORT_BY, required = false) @RequestParam(value = Constants.PARAM_SORT_BY, required = false) String sortBy,
			@ApiParam(value = Constants.PARAM_SORT_ORDER, required = false) @RequestParam(value = Constants.PARAM_SORT_ORDER, required = false) String sortOrder)
			throws Exception {
		if (startIndex == null) {
			startIndex = 0;
		}
		if (count == null) {
			count = 0;
		}
		if (sortBy == null) {
			sortBy = "id";
		}
		if (sortOrder == null) {
			sortOrder = "asc";
		}
		try {
			APIListResponse dtoResponse = manager.getAllUser(startIndex, count, sortBy, sortOrder);
			return new ResponseEntity<APIListResponse>(dtoResponse, HttpStatus.OK);
		} catch (IMSException e) {
			return Utils.getErrorResponseEntity(e.getError().getErrorDescr(),
					HttpStatus.valueOf(e.getError().getErrorCode()));
		}
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	@ApiOperation(value = "Get a user by id", notes = "Get a user", response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 401, message = "Authentication credentials are required") })
	@ResponseBody
	public ResponseEntity<?> getUser(@PathVariable long userId) throws Exception {

		try {
			UserDtoResponse dtoResponse = manager.getUser(userId);
			return new ResponseEntity<UserDtoResponse>(dtoResponse, HttpStatus.OK);
		} catch (IMSException e) {
			return Utils.getErrorResponseEntity(e.getError().getErrorDescr(),
					HttpStatus.valueOf(e.getError().getErrorCode()));
		}
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update user", notes = "Update user details", response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 401, message = "Authentication credentials are required") })
	@ResponseBody
	public ResponseEntity<?> getUser(@PathVariable long userId, @RequestBody UserDto updateDto) throws Exception {

		try {
			UserDtoResponse dtoResponse = manager.updateUser(userId, updateDto);
			return new ResponseEntity<UserDtoResponse>(dtoResponse, HttpStatus.OK);
		} catch (IMSException e) {
			return Utils.getErrorResponseEntity(e.getError().getErrorDescr(),
					HttpStatus.valueOf(e.getError().getErrorCode()));
		}
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete user", notes = "Delete a user from system", response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 401, message = "Authentication credentials are required") })
	@ResponseBody
	public ResponseEntity<?> deleteUser(@PathVariable long userId) throws Exception {

		try {
			manager.deleteUser(userId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IMSException e) {
			return Utils.getErrorResponseEntity(e.getError().getErrorDescr(),
					HttpStatus.valueOf(e.getError().getErrorCode()));
		}
	}
}
