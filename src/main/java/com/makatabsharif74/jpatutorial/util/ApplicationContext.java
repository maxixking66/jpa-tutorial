package com.makatabsharif74.jpatutorial.util;

import com.makatabsharif74.jpatutorial.repository.UserRepository;
import com.makatabsharif74.jpatutorial.repository.impl.UserRepositoryImpl;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();

    private static UserRepository userRepository;

    private ApplicationContext() {
    }

    public static UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl(em);
        }
        return userRepository;
    }
}
