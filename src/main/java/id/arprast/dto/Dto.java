/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.arprast.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import id.arprast.ref.StatusCode;

/**
 *
 * @author ari-prasetiyo
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dto implements Serializable {

	protected Long id;

	@JsonIgnore
	private StatusCode statusCode;

	@JsonIgnore
	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
