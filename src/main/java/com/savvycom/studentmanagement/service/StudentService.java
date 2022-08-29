package com.savvycom.studentmanagement.service;

import com.savvycom.studentmanagement.domain.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getByMajorId(Long majorId);

    Long countByMajorName(List<String> majorNames);

    List<StudentDTO> getStudentByMajorName(List<String> majorNames);

    List<StudentDTO> getStdNotDoTopic();

    List<StudentDTO> getStudentScoreZero(Double score);

    List<StudentDTO> getTop5Score();
}
