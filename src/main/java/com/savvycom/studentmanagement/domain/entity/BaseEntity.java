package com.savvycom.studentmanagement.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    private Date createdAt;
    private Date updatedAt;

    public void create() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public void update() {
        this.updatedAt = new Date();
    }
}
