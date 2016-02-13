package com.palette.busi.project.tms.core.base;

public class BaseException extends RuntimeException {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 7779099836790360728L;

	/**
	 * Creates a new GroupException object.
	 */
	public BaseException() {
		super();
	}

	/**
	 * @param message
	 */
	public BaseException(final String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BaseException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public BaseException(final Throwable cause) {
		super(cause);
	}
}
