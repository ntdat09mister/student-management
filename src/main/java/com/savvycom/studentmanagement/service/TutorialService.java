package com.savvycom.studentmanagement.service;

import com.savvycom.studentmanagement.domain.dto.TutorialDTO;

import java.util.List;

public interface TutorialService {
    List<TutorialDTO> getShowTutorial();

    List<TutorialDTO> getStudentAndPoint();

    List<TutorialDTO> getScoreAbove5OfTeam();
}
