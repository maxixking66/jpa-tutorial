package com.makatabsharif74.jpatutorial.service.impl;

import com.makatabsharif74.jpatutorial.base.service.impl.BaseServiceImpl;
import com.makatabsharif74.jpatutorial.domain.Wallet;
import com.makatabsharif74.jpatutorial.repository.WalletRepository;
import com.makatabsharif74.jpatutorial.service.WalletService;

public class WalletServiceImpl extends BaseServiceImpl<Wallet, Long, WalletRepository>
        implements WalletService {

    public WalletServiceImpl(WalletRepository repository) {
        super(repository);
    }

    @Override
    public Wallet save(Wallet wallet) {
        if (wallet.getId() == null) {
            return repository.save(wallet);
        } else {
            return super.save(wallet);
        }
    }
}
