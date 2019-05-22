package com.mng.spring.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mng.spring.model.Employee;

@FeignClient(name="springboot-message-process")
public interface MessageProcessClient {
	
	@RequestMapping(path = "/msg", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public void save(@RequestBody Employee employee);

}
