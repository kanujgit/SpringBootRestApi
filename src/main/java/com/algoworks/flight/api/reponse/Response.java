package com.algoworks.flight.api.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Response<T> {

	private Boolean status;

	@JsonProperty("status_code")
	private Integer statusCode;

	private Result<T> result;

	private Long timestamp;

	public Response(T rsult, String message) {
		super();
		status = true;
		statusCode = 200;
		timestamp = System.currentTimeMillis();
		result = new Result<T>(message, rsult);

	}

	public Response(String message) {
		super();
		status = true;
		statusCode = 200;
		timestamp = System.currentTimeMillis();
		result = new Result<T>(message);
	}

	public Response(String message, int statusCode) {
		super();
		status = false;
		this.statusCode = statusCode;
		timestamp = System.currentTimeMillis();
		result = new Result<T>(message);
	}


}
