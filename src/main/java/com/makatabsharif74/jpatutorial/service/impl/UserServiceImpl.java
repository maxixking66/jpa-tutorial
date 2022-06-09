package com.makatabsharif74.jpatutorial.service.impl;

import com.makatabsharif74.jpatutorial.base.service.impl.BaseServiceImpl;
import com.makatabsharif74.jpatutorial.domain.User;
import com.makatabsharif74.jpatutorial.repository.UserRepository;
import com.makatabsharif74.jpatutorial.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository>
        implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
