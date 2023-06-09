package com.user.micro.usercontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/user")
public class UseController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private RestTemplate rest;

	

	
	@GetMapping("/status/check")
	public String status()
	{
		return "Port number"+env.getProperty("local.server.port");
	}
	
	@GetMapping("/wish")
	public String getWish()
	{
		String url="http://localhost:8083/account/wish";
		String result = rest.getForObject(url, String.class);
		return "abhi "+result;
	}
	

}