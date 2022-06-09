package com.makatabsharif74.jpatutorial.repository.impl;

import com.makatabsharif74.jpatutorial.base.repository.impl.BaseRepositoryImpl;
import com.makatabsharif74.jpatutorial.domain.User;
import com.makatabsharif74.jpatutorial.repository.UserRepository;
import com.makatabsharif74.jpatutorial.service.dto.UserBriefProjection;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long>
        implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery(
                        "select u from User u where u.username = :username",
                        User.class
                ).setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public List<UserBriefProjection> getUsersBriefProjection() {

        return entityManager.createQuery(
                "select new com.makatabsharif74.jpatutorial.service.dto." +
                        "UserBriefProjection(u.id, u.firstName, u.lastName) from User u",
                UserBriefProjection.class
        ).getResultList();

    }
}
