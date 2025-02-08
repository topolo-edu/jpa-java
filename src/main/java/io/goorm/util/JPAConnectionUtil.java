package io.goorm.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConnectionUtil {
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jpa");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
