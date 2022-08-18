package com.savvycom.studentmanagement.service.impl;

import com.savvycom.studentmanagement.repository.dto.MajorDTO;
import com.savvycom.studentmanagement.repository.MajorRepository;
import com.savvycom.studentmanagement.service.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MajorServiceImpl implements MajorService {
    private final MajorRepository majorRepository;
    @Override
    public List<MajorDTO> countStdPerMajor(){
        return majorRepository.countStdPerMajor();
    }
}
