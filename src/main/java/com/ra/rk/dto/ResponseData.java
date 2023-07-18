package com.ra.rk.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ResponseData {
	String message;
	String status;
	Object data;

	public static class Builder {

	}

	public ResponseData(String message, String status, Object data) {
		this.message = message;
		this.status = status;
		this.data = data;
	}

}
