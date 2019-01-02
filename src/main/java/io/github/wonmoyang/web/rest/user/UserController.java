package io.github.wonmoyang.web.rest.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.wonmoyang.web.rest.user.vm.LoginVM;

@RestController
@RequestMapping("/api")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/login")
	public void login(@RequestBody LoginVM loginVM){
		logger.debug(" login. {} ", loginVM.toString());
	}
	
	@GetMapping("/users")
	public void getUsers(){
		logger.info("find users.");
	}
	
}
