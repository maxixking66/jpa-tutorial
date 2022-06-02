package com.makatabsharif74.jpatutorial;

import com.makatabsharif74.jpatutorial.util.HibernateUtil;

import javax.persistence.EntityManagerFactory;

public class JpaTutorialApplication {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                HibernateUtil.getEntityManagerFactory();

        System.out.println("done");
    }
}
