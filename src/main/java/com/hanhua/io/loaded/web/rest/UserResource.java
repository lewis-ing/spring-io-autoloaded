package com.hanhua.io.loaded.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hanhua.io.loaded.domain.User;
import com.hanhua.io.loaded.service.UserService;


@RestController
@RequestMapping("/api")
public class UserResource {

	private final Logger log = LoggerFactory.getLogger(UserResource.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/update/user",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> update(@RequestBody User user) throws URISyntaxException {
        log.debug("REST request to update User : {}", user);
        if (user.getId() != null) {
            return ResponseEntity.badRequest().header("Failure", "用户没有ID").body(user);
        }
        String u = user.toString();
        log.info("save user info....."+u);
        return ResponseEntity.created(new URI("/api/users/" + user.getId())).body(user);
    }
	
	@RequestMapping(value = "/findUser/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findUserById(@PathVariable Long id) throws URISyntaxException {
        log.debug("REST request to find User : {}", id);
		return Optional.ofNullable(userService.findUser(id))
				.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
