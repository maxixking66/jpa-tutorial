package com.makatabsharif74.jpatutorial.util;

import com.makatabsharif74.jpatutorial.repository.UserRepository;
import com.makatabsharif74.jpatutorial.repository.WalletRepository;
import com.makatabsharif74.jpatutorial.repository.impl.UserRepositoryImpl;
import com.makatabsharif74.jpatutorial.repository.impl.WalletRepositoryImpl;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();

    private static UserRepository userRepository;

    private static WalletRepository walletRepository;

    private ApplicationContext() {
    }

    public static UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl(em);
        }
        return userRepository;
    }

    public static WalletRepository getWalletRepository() {
        if (walletRepository == null) {
            walletRepository = new WalletRepositoryImpl(em);
        }
        return walletRepository;
    }

}
