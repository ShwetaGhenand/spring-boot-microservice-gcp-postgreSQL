package com.example.identityservice.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.identityservice.dto.ErrorResponse;

public class Utils {
	public static ResponseEntity<?> getErrorResponseEntity(String errorDesc, HttpStatus errorCode) {
		ResponseEntity<ErrorResponse> response = null;

		ErrorResponse object = new ErrorResponse(errorCode.value(), errorDesc);
		response = new ResponseEntity<ErrorResponse>(object, errorCode);
		return response;
	}
}
