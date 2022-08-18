package com.savvycom.studentmanagement.service.impl;

import com.savvycom.studentmanagement.repository.dto.StudentDTO;
import com.savvycom.studentmanagement.repository.StudentRepository;
import com.savvycom.studentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getByMajorId(Long majorId) {

        return studentRepository.getByMajorId(majorId);
    }

    @Override
    public Long countByMajorName(List<String> majorNames) {
        return studentRepository.countByMajorName(majorNames);
    }
    @Override
    public List<StudentDTO> getStudentByMajorName(List<String> majorNames){
        return studentRepository.getStudentByMajorName(majorNames);
    }
    @Override
    public List<StudentDTO> getStdNotDoTopic(){
        return studentRepository.getStdNotDoTopic();
    }
    @Override
    public List<StudentDTO> getStudentScoreZero(Double score){
        return studentRepository.getStudentScoreZero(score);
    }
    @Override
    public List<StudentDTO> getTop5Score(){
        return studentRepository.getTop5Score();
    }
}
