package com.neo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.neo.model.User;
import com.neo.mapper.UserMapper;

@RestController
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/getUsers")
	public List<User> getUsers() {
		List<User> users=userMapper.getAll();
		return users;
	}
	
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable Long id) {
    	User user=userMapper.getOne(id);
        return user;
    }
    
    @PostMapping("/add")
    public void save(@RequestBody User user) {
    	userMapper.insert(user);
    }
    
    @PutMapping(value="update")
    public void update(@RequestBody User user) {
    	userMapper.update(user);
    }
    
    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }
    
    
}