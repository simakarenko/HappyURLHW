package com.gmail.simakarenko93;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        try {
            // create connection
            emf = Persistence.createEntityManagerFactory("JPAMyBankTest");
            em = emf.createEntityManager();
            try {
                System.out.println("Hello");
            } finally {
                em.close();
                emf.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
