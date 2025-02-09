package io.goorm.model.twoway;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "video")
public class Video {

    public Video() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_seq")
    private Long videoSeq;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "video")
    private String video;

    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime createAt;


    @ManyToOne
    @JoinColumn(name = "member_seq") // 외래키 지정
    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getVideoSeq() {
        return videoSeq;
    }

    public void setVideoSeq(Long videoSeq) {
        this.videoSeq = videoSeq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
