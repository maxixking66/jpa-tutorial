package com.makatabsharif74.jpatutorial;

import com.makatabsharif74.jpatutorial.domain.*;
import com.makatabsharif74.jpatutorial.util.ApplicationContext;
import com.makatabsharif74.jpatutorial.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaTutorialApplication {

    public static void main(String[] args) {


        EntityManager entityManager =
                HibernateUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class, 24L);

        System.out.println(entityManager.contains(user));

        entityManager.detach(user);

        System.out.println(entityManager.contains(user));

        user.setFirstName("x");
        user.setLastName("x");

        user = entityManager.merge(user);

        user.setFirstName("m");
        user.setLastName("m");

        entityManager.getTransaction().commit();

    }

    private static void showFetchTypeExample() {
        List<User> all = ApplicationContext.getUserService().findAll();

        System.out.println("all is here");

        all.forEach(data -> System.out.println(data));

        System.out.println("done");
    }

    private static void addProductsToCart() {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();

        Radio radio = new Radio();
        radio.setFrequency(10);
        radio.setPower(110L);
        radio.setPrice(11000L);
        entityManager.persist(radio);


        TV tv = new TV();
        tv.setInch(42);
        tv.setPower(220L);
        tv.setPrice(22000L);
        entityManager.persist(tv);

        Cart cart = new Cart();
        cart.getProductList().add(radio);
        cart.getProductList().add(tv);
        entityManager.persist(cart);

        entityManager.getTransaction().commit();


        System.out.println(
                entityManager.createQuery("select c from Cart c", Cart.class).getResultList()
        );

        /*System.out.println(
                entityManager.createQuery("select c from Radio c", Radio.class).getResultList()
        );*/
    }

    private static void insertUserWithUserService() {
        ApplicationContext.getUserService().save(
                new User("mehrshad", "samaei", null, "1333333", true)
        );
    }

    private static void insertUserWithWallet() {
        Wallet wallet = new Wallet();
        wallet = ApplicationContext.getWalletRepository().save(wallet);
//        Wallet newW = new Wallet();
//        newW.setId(wallet.getId());
        User user = new User();
        user.setLastName("asgari");
        user.setActive(true);
        user.setWallet(wallet);
        throw new RuntimeException();
//        ApplicationContext.getUserRepository().save(user);
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
