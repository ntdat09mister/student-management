package com.savvycom.studentmanagement.controller;

import com.savvycom.studentmanagement.repository.dto.TutorialDTO;
import com.savvycom.studentmanagement.service.TutorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tutorial")
@RequiredArgsConstructor
public class TutorialController {
    private final TutorialService tutorialService;
    @GetMapping
    public List<TutorialDTO> getShowTutorial(){
        return tutorialService.getShowTutorial();
    }
    @GetMapping("/getStudentAndPoint")
    public List<TutorialDTO> getStudentAndPoint(){
        return tutorialService.getStudentAndPoint();
    }
    @GetMapping("/getScoreAbove5OfTeam")
    public List<TutorialDTO> getScoreAbove5OfTeam(){
        return tutorialService.getScoreAbove5OfTeam();
    }
}
