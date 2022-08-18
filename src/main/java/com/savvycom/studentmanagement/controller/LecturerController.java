package com.savvycom.studentmanagement.controller;
import com.savvycom.studentmanagement.repository.dto.LecturerDTO;
import com.savvycom.studentmanagement.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lecturer")
@RequiredArgsConstructor
public class LecturerController {
    private final LecturerService lecturerService;

    @GetMapping
    public List<LecturerDTO> getListLecturer() {
        return lecturerService.getListLecturer();
    }
    @GetMapping("/get-by-major-name")
    public List<LecturerDTO> getListByMajorName(@RequestParam("majorName") List<String> majorName){
        return lecturerService.getListByMajorName(majorName);
    }
    @GetMapping("/countByMajorName")
    public Long countByMajorName(@RequestParam("majorNames")List<String> majorNames){
        return lecturerService.countByMajorName(majorNames);
    }
    @GetMapping("/getLecturerTutoMore3Std")
    public List<LecturerDTO> getLecturerTutoMore3Std(@RequestParam("NumberStd") Long NumberStd){
        return lecturerService.getLecturerTutoMore3Std(NumberStd);
    }
}
