package com.savvycom.studentmanagement.controller;
import com.savvycom.studentmanagement.domain.dto.LecDto;
import com.savvycom.studentmanagement.domain.dto.LecturerDTO;
import com.savvycom.studentmanagement.domain.dto.PageDto;
import com.savvycom.studentmanagement.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getListLecturerPage(@RequestParam(value = "firstDay", required = false) String firstDay,
                                                 @RequestParam(value = "lastDay", required = false) String lastDay,
                                           @RequestParam(value = "offset", required = false) Integer offset,
                                           @RequestParam(value = "limit", required = false) Integer limit,
                                           @RequestParam(value = "sort", required = false) String sort,
                                           @RequestParam(value = "sortBy", required = false) List<String> sortBy) {
        return ResponseEntity.ok(lecturerService.getListLecturerPage(firstDay,lastDay,offset,limit,sort,sortBy));
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
