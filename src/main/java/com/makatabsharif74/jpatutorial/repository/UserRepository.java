package com.makatabsharif74.jpatutorial.repository;

import com.makatabsharif74.jpatutorial.base.repository.BaseRepository;
import com.makatabsharif74.jpatutorial.domain.User;

public interface UserRepository extends BaseRepository<User, Long> {

    User findByUsername(String username);

}
