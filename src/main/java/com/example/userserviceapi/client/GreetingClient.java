package com.example.userserviceapi.client;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.userserviceapi.web.api.model.GreetingResponse;
import com.example.userserviceapi.web.api.model.PersonGreet;

import io.swagger.annotations.ApiParam;

@FeignClient(value = "client", url = "http://localhost:8080")
public interface GreetingClient {

	@RequestMapping(value = "/greeting", produces = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<GreetingResponse> hello(

			@ApiParam(value = "Person's name", required = true) @Valid @RequestBody PersonGreet name);

}
