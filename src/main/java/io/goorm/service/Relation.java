package io.goorm.service;

import io.goorm.model.twoway.Member;
import io.goorm.model.twoway.Video;
import io.goorm.util.JPAConnectionUtil;
import jakarta.persistence.EntityManager;

public class Relation {

    public void toway() {

        EntityManager em  = JPAConnectionUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Member member = new Member();
            member.setMemberName("testUser");

            Video video1 = new Video();
            video1.setTitle("Video 1");
            video1.setVideo("video1.mp4");
            video1.setMember(member); // 관계 설정

            Video video2 = new Video();
            video2.setTitle("Video 2");
            video2.setVideo("video2.mp4");
            video2.setMember(member); // 관계 설정

            member.getVideos().add(video1);
            member.getVideos().add(video2);

            em.persist(member);
            em.persist(video1);
            em.persist(video2);

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

