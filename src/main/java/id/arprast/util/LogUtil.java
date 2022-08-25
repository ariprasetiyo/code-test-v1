package id.arprast.util;

import id.arprast.controller.rest.ApiRestController;
import id.arprast.http.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import id.arprast.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

public class LogUtil {

	private static final String REQUEST = "class={}, request={}";
	private static final String RESPONSE = "class={}, response={}";
	private static final Logger logger = LoggerFactory.getLogger(ApiRestController.class);
	private static final ObjectMapper jsonMapper = new ObjectMapper();
	private static final TypeReference<Object> objectRef = new TypeReference<Object>() {
	};
	private static final TypeReference<ResponseEntity<ResponseDto>> responseRef = new TypeReference<ResponseEntity<ResponseDto>>() {
	};
	private static final ObjectWriter requestWritter = jsonMapper.writerFor(objectRef);
	private static final ObjectWriter responseWritter = jsonMapper.writerFor(responseRef);

	public static void logRequest(final Class aClass, final Object request) {
		String jsonRequest = null;
		try {
			jsonRequest = requestWritter.writeValueAsString(request);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		logger.info(REQUEST, aClass.getSimpleName(), jsonRequest);
	}

	public static ResponseEntity<Response> logResponse(final Class aClass, final ResponseEntity<Response> response) {
		String jsonResponse = null;
		try {
			jsonResponse = responseWritter.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		logger.info(RESPONSE, aClass.getSimpleName(), jsonResponse);
		return response;
	}
}
