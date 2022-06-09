package com.makatabsharif74.jpatutorial.repository;

import com.makatabsharif74.jpatutorial.base.repository.BaseRepository;
import com.makatabsharif74.jpatutorial.domain.User;
import com.makatabsharif74.jpatutorial.service.dto.UserBriefProjection;

import java.util.List;

public interface UserRepository extends BaseRepository<User, Long> {

    User findByUsername(String username);

    List<UserBriefProjection> getUsersBriefProjection();
}
