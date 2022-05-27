package com.br.willmathlock.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("AlgaWorks-PU");
    }

    public static EntityManager getFactory () {
        return factory.createEntityManager();
    }
    public static void close() {
        factory.close();
    }
}
