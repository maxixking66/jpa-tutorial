package com.makatabsharif74.jpatutorial;

import com.makatabsharif74.jpatutorial.domain.User;
import com.makatabsharif74.jpatutorial.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaTutorialApplication {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                HibernateUtil.getEntityManagerFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<User> query = entityManager.createQuery(
                "select u from User u", User.class
        );

        List<User> userList = query.getResultList();
        System.out.println(userList);


        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        User user = new User("mohsen", "asgari", "mat", "12345678");
        entityManager.persist(user);
        System.out.println(user);
        transaction.commit();

        userList = query.getResultList();
        System.out.println(userList);


        System.out.println("end");
    }
}
