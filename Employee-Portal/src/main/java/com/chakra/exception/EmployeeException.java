package com.societegenerale.exception;

public class EmployeeException extends Exception {

	private static final long serialVersionUID = 3668223108712552731L;
	private String message;
	private int statusCode;
	private StackTraceElement[] stackTrace;
	private Throwable cause;
	private Exception exception;
	public EmployeeException() {
		super();
	}
	public EmployeeException(String message) {
		this.message = message;
	}
	
	public EmployeeException(Exception excp) {
		this.message = excp.getMessage();
		this.stackTrace = excp.getStackTrace();
		this.cause = excp.getCause();
	}

	public EmployeeException(String key, Exception e) {
		this.setException(e);
		this.message = key;
	}

    @Override
	public String getMessage() {
		return message;
	}
	@Override
	public StackTraceElement[] getStackTrace() {
		return stackTrace;
	}

	@Override
	public Throwable getCause() {
		return cause;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
