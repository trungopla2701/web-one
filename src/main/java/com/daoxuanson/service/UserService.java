package com.daoxuanson.service;

import com.daoxuanson.entity.Role;
import com.daoxuanson.entity.User;
import com.daoxuanson.model.request.UserRequest;

import java.util.List;
import java.util.Set;

public interface UserService {
    User insert(UserRequest userRequest);
	void delete(Long id);
	void update(Long id ,UserRequest userRequest);
	User findUserByUserNameAndPassword(String userName , String passsword);
	List<User> findAll();
}
