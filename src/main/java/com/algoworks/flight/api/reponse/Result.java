package com.algoworks.flight.api.reponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class Result<T> {

	private String message;

	@JsonInclude(Include.NON_NULL)
	private T data;

	private Integer count = 0;

	@SuppressWarnings("rawtypes")
	public Result(String message, T data) {
		super();
		this.message = message;
		this.data = data;

		if (data instanceof List) { // raw type
			count = ((List) data).size();
		} else {
			count = 1;
		}

	}

	public Result() {
		super();
	}

	public Result(String message) {
		super();
		this.message = message;

	}

}
