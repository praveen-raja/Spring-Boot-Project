package com.restservices.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

//	@GetMapping
//	public String getUsers() {
//		return "HTTP GET Request was sent";
//
//	}

	// Path parameter
	@GetMapping(path = "/{userid}")
	public String getUser(@PathVariable String userid) {
		return "HTTP GET Request was sent to user id:" + userid;

	}

	// Query parameter
	@GetMapping
	public String getUsersWithQueryParameter(@RequestParam(value = "page") int pageno,
			@RequestParam(value = "limit") int userlimit) {
		return "HTTP GET Request was sent for\n page number: " + pageno + "\n userlimit: " + userlimit;

	}

	@PostMapping
	public String createUsers() {
		return "HTTP POST Request was sent";

	}

	@PutMapping
	public String updateUsers() {
		return "HTTP PUT Request was sent";

	}

	@DeleteMapping
	public String deleteUsers() {
		return "HTTP DELETE  Request was sent";

	}
}
