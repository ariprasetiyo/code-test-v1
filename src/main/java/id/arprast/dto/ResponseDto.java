package id.arprast.dto;


import id.arprast.ref.StatusCode;

public class ResponseDto extends Dto {

	private static final long serialVersionUID = -191184234025791265L;

	private StatusCode statusCode;

	private String message;

	private Object responseData;

	public ResponseDto() {

	}

	public ResponseDto(StatusCode statusCode, String message, Object responseData) {
		this.message = message;
		this.statusCode = statusCode;
		this.responseData = responseData;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
		this.message = statusCode.desc;
	}

	@Override
	public StatusCode getStatusCode() {
		return statusCode;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
}
