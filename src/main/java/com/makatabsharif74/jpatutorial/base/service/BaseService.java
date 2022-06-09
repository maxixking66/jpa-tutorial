package com.makatabsharif74.jpatutorial.base.service;

import com.makatabsharif74.jpatutorial.base.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity<ID>, ID extends Serializable> {

    E save(E e);

    E findById(ID id);

    List<E> findAll();

    void deleteById(ID id);

    long countAll();

}
