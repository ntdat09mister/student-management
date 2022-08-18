package com.savvycom.studentmanagement.service.impl;

import com.savvycom.studentmanagement.repository.dto.LecturerDTO;
import com.savvycom.studentmanagement.repository.LectureRepository;
import com.savvycom.studentmanagement.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LecturerServiceImpl implements LecturerService {
    private final LectureRepository lectureRepository;
    @Override
    public List<LecturerDTO> getListLecturer() {
        return lectureRepository.getListLecturer();
    }

    @Override
    public List<LecturerDTO> getListByMajorName(List<String> majorName) {
        return lectureRepository.getListByMajorName(majorName);
    }

    @Override
    public Long countByMajorName(List<String> majorNames) {
        return lectureRepository.countByMajorName(majorNames);
    }
    @Override
    public List<LecturerDTO> getLecturerTutoMore3Std(Long NumberStd){
        return lectureRepository.getLecturerTutoMore3Std(NumberStd);
    }

}
