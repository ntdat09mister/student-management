package com.savvycom.studentmanagement.service.impl;
import com.savvycom.studentmanagement.domain.entity.Lecturer;
import com.savvycom.studentmanagement.domain.dto.LecturerDTO;
import com.savvycom.studentmanagement.repository.LectureRepository;
import com.savvycom.studentmanagement.repository.impl.LecturerRepositoryImpl;
import com.savvycom.studentmanagement.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LecturerServiceImpl implements LecturerService {
    private final LectureRepository lectureRepository;
    private final LecturerRepositoryImpl lecturerRepositoryImpl;
    @Override
    public List<LecturerDTO> getListByMajorName(List<String> majorName) {
        return lectureRepository.getListByMajorName(majorName);
    }

    @Override
    public Long countByMajorName(List<String> majorNames) {
        return lectureRepository.countByMajorName(majorNames);
    }
    @Override
    public List<LecturerDTO> getLecturerTutoMore3Std(Long NumberStd){
        return lectureRepository.getLecturerTutoMore3Std(NumberStd);
    }

    @Override
    public Page<Lecturer> getListLecturerPage(String firstDay,String lastDay , Integer offset, Integer limit, String sort, List<String> sortBy) {
        if(offset==null){
            offset=0;
        }
        Sort.Direction direction = Sort.Direction.DESC;
        if (sort != null) {
            if (sort.equals("asc")) {
                direction = Sort.Direction.ASC;
            } else {
                sort = "desc";
            }
        }

        if (CollectionUtils.isEmpty(sortBy)) {
            sortBy = new ArrayList<>();
            sortBy.add("id");
        }
        PageRequest pageRequest = PageRequest.of(offset,limit,direction,sortBy.toArray(new String[sortBy.size()]));
        Page<Lecturer> lecturers = lecturerRepositoryImpl.getLecturerCon(firstDay,lastDay ,offset,limit,sort,sortBy,pageRequest);
        return lecturers;
    }
}
