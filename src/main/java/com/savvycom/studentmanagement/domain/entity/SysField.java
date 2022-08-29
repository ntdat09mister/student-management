package com.savvycom.studentmanagement.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "sys_field")
public class SysField {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tableName;
    private String fieldName;
    private Long columnIndex;
}
