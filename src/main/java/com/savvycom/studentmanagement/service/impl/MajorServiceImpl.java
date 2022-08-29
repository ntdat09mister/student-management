package com.savvycom.studentmanagement.service.impl;
import com.savvycom.studentmanagement.repository.impl.Custom;
import com.savvycom.studentmanagement.service.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MajorServiceImpl implements MajorService {
    private final Custom custom;

    @Override
    public Object getMajorSysField() {
        return custom.getMajorSysField();
    }
}
