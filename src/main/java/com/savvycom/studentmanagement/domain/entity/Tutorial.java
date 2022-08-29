package com.savvycom.studentmanagement.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tutorial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(Tutorial.PK.class)
public class Tutorial extends BaseEntity {
    @Id
    private Long studentId;

    @Id
    private Long teamId;

    @Id
    private Long lecturerId;

    @Id
    private Long topicId;

    private Double score;

    @Data
    public static class PK implements Serializable {
        private Long studentId;
        private Long teamId;
        private Long lecturerId;
        private Long topicId;
    }
}
