package com.savvycom.studentmanagement.repository.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lecturer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Lecturer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long majorId;
}
