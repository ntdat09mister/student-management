package com.savvycom.studentmanagement.service.impl;

import com.savvycom.studentmanagement.domain.dto.TutorialDTO;
import com.savvycom.studentmanagement.repository.TutorialRepository;
import com.savvycom.studentmanagement.service.TutorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorialServiceImpl implements TutorialService {
    private final TutorialRepository tutorialRepository;
    @Override
    public List<TutorialDTO> getShowTutorial(){
        return tutorialRepository.getShowTutorial();
    }
    @Override
    public List<TutorialDTO> getStudentAndPoint(){
        return tutorialRepository.getStudentAndPoint();
    }
    @Override
    public List<TutorialDTO> getScoreAbove5OfTeam(){
        return tutorialRepository.getScoreAbove5OfTeam();
    }
}
