package com.daoxuanson.service.impl;

import com.daoxuanson.entity.Role;
import com.daoxuanson.entity.User;
import com.daoxuanson.model.request.UserRequest;
import com.daoxuanson.repository.RoleRepository;
import com.daoxuanson.repository.UserRepository;
import com.daoxuanson.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }







    public User insert(UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        Set<Role> roles = new HashSet<Role>();
            for (Long id: userRequest.getIds()) {
                Role role = roleRepository.findOne(id);
                roles.add(role);
            }
        user.setRoles(roles);
        userRepository.save(user);
       // roles.forEach(role -> role.getUsers().add(user)); có thể bỏ
        return user;
    }

// note ham save neu co roi thi update con chua co thi insert


	public void delete(Long id) {

		User user = userRepository.findOne(id);
		for(Role ignored : user.getRoles()){
			roleRepository.getOne(ignored.getId()).getUsers().remove(user);
        }
		userRepository.delete(user);
    }

	public void update(Long id , UserRequest userRequest)
	{
		User user = userRepository.findOne(id);
		if(user == null)
		{
			return;
		}
		User user1 = new User();
		BeanUtils.copyProperties(userRequest , user1);
		user.setUserName(user1.getUserName());
		user.setPassword(user1.getPassword());
		Date date = new Date();
		user.setModifiedDate(date);
		Set<Role> roles = new HashSet<Role>();
		for (Long ide: userRequest.getIds()) {
			Role role = roleRepository.findOne(ide);
			roles.add(role);
		}
		user.setRoles(roles);//về xem
		userRepository.save(user);

	}

	@Override
	public User findUserByUserNameAndPassword(String userName, String password) {
		User user = userRepository.findUsersByUserNameAndPassword(userName, password);

		return user;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
}


