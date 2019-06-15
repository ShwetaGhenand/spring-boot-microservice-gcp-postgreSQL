package com.example.identityservice.dto;

public class ErrorResponse {

	private int errorCode = 500;

	private String errorDescr;

	private int reasonCode;

	public String getErrorDescr() {
		return errorDescr;
	}

	public void setErrorDescr(String errorDescr) {
		this.errorDescr = errorDescr;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(int reasonCode) {
		this.reasonCode = reasonCode;
	}

	public ErrorResponse(int errorCode, String errorDescr) {
		super();
		this.errorCode = errorCode;
		this.errorDescr = errorDescr;
	}

	public ErrorResponse(int errorCode, String errorDescr, int reasonCode) {
		super();
		this.errorCode = errorCode;
		this.errorDescr = errorDescr;
		this.reasonCode = reasonCode;
	}

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String errorDescr) {
		super();
		this.errorDescr = errorDescr;
	}
}
