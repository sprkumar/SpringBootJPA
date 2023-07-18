package com.ra.rk.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
@JsonInclude(Include.NON_NULL)
public class ResponseDto {

	private String action;
	private String result;
	private String message;
	private Object data;
	private HttpStatus status;
	private Integer code;

	public ResponseDto() {

	}

	public ResponseDto(String message, Object data, HttpStatus status) {

		this.message = message;
		this.data = data;
		this.status = status;

	}

	@Override
	public String toString() {
		return "ResponseDto [action=" + action + ", result=" + result + ", message=" + message + ", data=" + data
				+ ", status=" + status + ", code=" + code + "]";
	}
	

}
