package com.savvycom.studentmanagement.repository.dto;

import java.util.Date;

public interface StudentDTO {
    Long getId();
    String getName();
    String getTopicName();
    Double getScore();
    Date getBirthday();
    Integer getAge();
}
