package com.daoxuanson.service;

import com.daoxuanson.entity.Role;

import java.util.List;

public interface RoleService {
	Role findOne(Long id);
	List<Role> findAll();
}
