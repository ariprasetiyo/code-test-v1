package id.arprast.util;

import id.arprast.http.Request;
import id.arprast.http.Response;

public class Util {

	public static Response buildResponse(final Request request){
		final Response responseDto = new Response();
		responseDto.setResponseId(request.getRequestId());
		return responseDto;
	}
}
