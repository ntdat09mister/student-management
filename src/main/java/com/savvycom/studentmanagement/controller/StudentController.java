package com.savvycom.studentmanagement.controller;

import com.savvycom.studentmanagement.domain.dto.StudentDTO;
import com.savvycom.studentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentDTO> getStudentsByMajorId(@RequestParam("majorId") Long majorId) {
        return studentService.getByMajorId(majorId);
    }
    @GetMapping("/count")
    public Long countByMajorName(@RequestParam("majorName") List<String> majorNames){
        return studentService.countByMajorName(majorNames);
    }
    @GetMapping("/getStudentByMajorName")
    public List<StudentDTO> getStudentByMajorName(@RequestParam(required = false,name="majorNames") List<String> majorNames){
        return studentService.getStudentByMajorName(majorNames);
    }
    @GetMapping("/getStdNotDoTopic")
    public List<StudentDTO> getStdNotDoTopic(){
        return studentService.getStdNotDoTopic();
    }
    @GetMapping("/getStudentScoreZero")
    public List<StudentDTO> getStudentScoreZero(@RequestParam("score") Double score){
        return studentService.getStudentScoreZero(score);
    }
    @GetMapping("/getTop5Score")
    public List<StudentDTO> getTop5Score(){
        return studentService.getTop5Score();
    }
}
