package com.dream.gyms.dingtalk.exception;

public class OApiException extends Exception {

	private static final long serialVersionUID = 1L;
	public static final int ERR_RESULT_RESOLUTION = -2;

	public OApiException(String field) {
		this(ERR_RESULT_RESOLUTION, "Cannot resolve field " + field + " from oapi resonpse");
	}

	public OApiException(int errCode, String errMsg) {
		super("error code: " + errCode + ", error message: " + errMsg);
	}
}
