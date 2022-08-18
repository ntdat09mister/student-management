package com.savvycom.studentmanagement.controller;

import com.savvycom.studentmanagement.repository.dto.MajorDTO;
import com.savvycom.studentmanagement.service.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("major")
@RequiredArgsConstructor
public class MajorController {
    private final MajorService majorService;
    @GetMapping("/countStdPerMajor")
    public List<MajorDTO> countStdPerMajor(){
        return majorService.countStdPerMajor();
    }
}
