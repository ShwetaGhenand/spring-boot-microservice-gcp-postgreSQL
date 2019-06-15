package com.example.identityservice.exception;

import com.example.identityservice.dto.ErrorResponse;

public class IMSException extends Exception {

	private static final long serialVersionUID = -97489601876868146L;

	private ErrorResponse error;

	/**
	 *
	 * @param errorMessage
	 */
	public IMSException(String errorMessage) {
		super(errorMessage);
		this.error = new ErrorResponse(errorMessage);
	}

	/**
	 * @param errorMessage
	 */
	public IMSException(int errorCode, String errorMessage) {
		super(errorMessage);
		this.error = new ErrorResponse(errorCode, errorMessage);
	}

	/**
	 *
	 * @param errorMessage
	 * @param cause
	 */
	public IMSException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
		this.error = new ErrorResponse(errorMessage);
	}

	/**
	 * Default Constructor
	 */
	public IMSException() {
		super();
		this.error = new ErrorResponse("INTERNAL_SERVER_ERROR");
	}

	/**
	 * @return the errorDescr
	 */
	public String getErrorMessage() {
		return this.error.getErrorDescr();
	}

	/**
	 * @param errorMessage the errorDescr to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.error.setErrorDescr(errorMessage);
	}

	/**
	 * @return the error
	 */
	public ErrorResponse getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(ErrorResponse error) {
		this.error = error;
	}

}
