package com.savvycom.studentmanagement.service;
import com.savvycom.studentmanagement.domain.entity.Lecturer;
import com.savvycom.studentmanagement.domain.dto.LecturerDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LecturerService {

    List<LecturerDTO> getListByMajorName(List<String> majorName);

    Long countByMajorName(List<String> majorNames);

    List<LecturerDTO> getLecturerTutoMore3Std(Long NumberStd);

    Page<Lecturer> getListLecturerPage(String firstDay,String lastDay , Integer offset, Integer limit, String sort, List<String> sortBy);
}
