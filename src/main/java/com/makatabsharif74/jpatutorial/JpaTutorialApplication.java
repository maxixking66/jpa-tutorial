package com.makatabsharif74.jpatutorial;

import com.makatabsharif74.jpatutorial.domain.User;
import com.makatabsharif74.jpatutorial.domain.Wallet;
import com.makatabsharif74.jpatutorial.util.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaTutorialApplication {

    public static void main(String[] args) {

        System.out.println(
                ApplicationContext.getUserRepository().findAll()
        );

        insertUserWithWallet();

        System.out.println(
                ApplicationContext.getUserRepository().findAll()
        );


    }

    private static void insertUserWithWallet() {
        Wallet wallet = new Wallet();
        wallet = ApplicationContext.getWalletRepository().save(wallet);
//        Wallet newW = new Wallet();
//        newW.setId(wallet.getId());
        User user = new User();
        user.setLastName("saberi");
        user.setActive(true);
        user.setWallet(wallet);
        ApplicationContext.getUserRepository().save(user);
    }

    private static void doFirstExample(EntityManager entityManager) {
        TypedQuery<User> query = entityManager.createQuery(
                "select u from User u", User.class
        );

        List<User> userList = query.getResultList();
        System.out.println(userList);


        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        User user = new User("mohsen", "asgari", "mat", "12345678", true);
        entityManager.persist(user);
        System.out.println(user);
        transaction.commit();

        userList = query.getResultList();
        System.out.println(userList);
    }
}

class Product {

}

class Cart {
    Product[] products = new Product[10];

    private void test() {
        products[0] = new Product();
    }
}