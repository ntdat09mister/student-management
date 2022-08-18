package com.savvycom.studentmanagement.service;

import com.savvycom.studentmanagement.repository.dto.MajorDTO;

import java.util.List;

public interface MajorService {
    List<MajorDTO> countStdPerMajor();
}
