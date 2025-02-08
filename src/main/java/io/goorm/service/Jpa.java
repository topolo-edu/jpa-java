package io.goorm.service;

import io.goorm.model.Member;
import io.goorm.util.JPAConnectionUtil;
import jakarta.persistence.EntityManager;

public class Jpa {


    public void createMember() {

        EntityManager em  = JPAConnectionUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Member member = new Member();
            member.setMemberName("testUser");


            em.persist(member);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // 트랜잭션 롤백
            }
            e.printStackTrace(); // 예외 출력
        } finally {
            em.close();
        }

    }
}
