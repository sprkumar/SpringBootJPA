package com.ra.rk.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String exName;
	private Long id;

	public ResourceNotFoundException(String exName, Long id) {
		this.exName = exName;
		this.id = id;
	}

	@Override
	public String toString() {
		return "ResourceNotFoundException [exName=" + exName + ", id=" + id + "]";
	}

}
