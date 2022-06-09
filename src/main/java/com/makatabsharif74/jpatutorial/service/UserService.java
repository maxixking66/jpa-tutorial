package com.makatabsharif74.jpatutorial.service;

import com.makatabsharif74.jpatutorial.base.service.BaseService;
import com.makatabsharif74.jpatutorial.domain.User;

public interface UserService extends BaseService<User, Long> {

    User findByUsername(String username);
}
