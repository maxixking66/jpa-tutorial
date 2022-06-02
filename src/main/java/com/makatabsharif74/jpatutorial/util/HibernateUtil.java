package com.makatabsharif74.jpatutorial.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory emf /*= Persistence.createEntityManagerFactory("default");*/;

    static {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
