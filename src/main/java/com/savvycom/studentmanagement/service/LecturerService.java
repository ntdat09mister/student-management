package com.savvycom.studentmanagement.service;

import com.savvycom.studentmanagement.repository.dto.LecturerDTO;

import java.util.List;

public interface LecturerService {

    List<LecturerDTO> getListLecturer();

    List<LecturerDTO> getListByMajorName(List<String> majorName);

    Long countByMajorName(List<String> majorNames);

    List<LecturerDTO> getLecturerTutoMore3Std(Long NumberStd);
}
