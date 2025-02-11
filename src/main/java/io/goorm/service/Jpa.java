package io.goorm.service;

import io.goorm.model.Member;
import io.goorm.util.JPAConnectionUtil;
import jakarta.persistence.EntityManager;
import org.apache.commons.lang3.RandomStringUtils;

public class Jpa {


    public void createMember() {

        String randomAlpha = RandomStringUtils.randomAlphabetic(10);
        System.out.println(randomAlpha);

        EntityManager em  = JPAConnectionUtil.getEntityManager();

        try {
            em.getTransaction().begin();
/*
            Member member = new Member();
            member.setMemberName("testUser");


            em.persist(member);*/

/*
            Member member = em.find(Member.class, 1L);
            em.remove(member);  // 연관된 video도 함께 삭제됨
*/

/*            //조회 테스트
            System.out.println("##################################before-find");
            Member exsistMember = em.find(Member.class,3L);
            System.out.println("##################################after-find");


            System.out.println("##################################before-find2");
            Member exsistMember2 = em.find(Member.class,3L);
            System.out.println("##################################after-find2");

            System.out.println("##################################before-update");
            exsistMember.setMemberName("23232");
            System.out.println("##################################before-update");*/

/*            //flush테스트
            System.out.println("##################################before-flush");
            em.flush();
            System.out.println("##################################after-flush");*/

/*            //clear테스트
            System.out.println("##################################before-clear");
            em.clear();
            System.out.println("##################################after-clear");

            //find테스트
            System.out.println("##################################before-find3");
            Member exsistMember3 = em.find(Member.class,3L);
            System.out.println("##################################after-find3");*/


            //등록 테스트
            Member member = new Member();
            member.setMemberName("testUser121212");

            System.out.println("##################################before-persist");
            em.persist(member);
            System.out.println("##################################before-persist");

/*
            //flush테스트
            System.out.println("##################################before-flush");
            em.flush();
            System.out.println("##################################after-flush");
*/

/*            //commit테스트
            System.out.println("##################################before-commit");
            em.getTransaction().commit();
            System.out.println("##################################after-commit");*/

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
