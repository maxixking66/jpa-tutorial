package com.makatabsharif74.jpatutorial.service.impl;

import com.makatabsharif74.jpatutorial.base.service.impl.BaseServiceImpl;
import com.makatabsharif74.jpatutorial.domain.User;
import com.makatabsharif74.jpatutorial.domain.Wallet;
import com.makatabsharif74.jpatutorial.repository.UserRepository;
import com.makatabsharif74.jpatutorial.service.UserService;
import com.makatabsharif74.jpatutorial.service.WalletService;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository>
        implements UserService {

    private final WalletService walletService;

    public UserServiceImpl(UserRepository repository, WalletService walletService) {
        super(repository);
        this.walletService = walletService;
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            try {
                repository.beginTransaction();
                Wallet wallet = walletService.save(new Wallet());
                user.setWallet(wallet);
                user = repository.save(user);
//                add some logic
                repository.commitTransaction();
                return user;
            } catch (Exception e) {
                e.printStackTrace();
                repository.rollbackTransaction();
                throw e;
            }
        } else {
            return super.save(user);
        }

    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
