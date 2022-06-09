package com.makatabsharif74.jpatutorial.repository.impl;

import com.makatabsharif74.jpatutorial.base.repository.impl.BaseRepositoryImpl;
import com.makatabsharif74.jpatutorial.domain.Wallet;
import com.makatabsharif74.jpatutorial.repository.WalletRepository;

import javax.persistence.EntityManager;

public class WalletRepositoryImpl extends BaseRepositoryImpl<Wallet, Long>
        implements WalletRepository {

    public WalletRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Wallet> getEntityClass() {
        return Wallet.class;
    }

}
