package com.savvycom.studentmanagement.repository.impl;

import com.savvycom.studentmanagement.domain.entity.Major;
import com.savvycom.studentmanagement.repository.MajorRepository;
import com.savvycom.studentmanagement.repository.SysFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@RequiredArgsConstructor
@Repository
public class Custom {
    @PersistenceContext
    private EntityManager entityManager;
    private final SysFieldRepository sysFieldRepository;
    private final MajorRepository majorRepository;
    public Object getMajorSysField(){
        List<Major> majors = majorRepository.findAll();
        List<String> sysFields = sysFieldRepository.findField();
        List<Map<String,Object>> mapList = new ArrayList<>();
        for(int i = 0;i<majors.size();i++) {
            mapList.add(convertEntity(majors.get(i), sysFields));
        }
        return mapList;
    }
    private Map<String,Object> convertEntity(Major major,List<String> sysFields){
        Map<String,Object> map = new LinkedHashMap<>();
        for(int i=0;i<sysFields.size();i++){
            switch (sysFields.get(i).toLowerCase()){
                case "id":
                    map.put("id",major.getId());
                    break;
                case "code":
                    map.put("code",major.getCode());
                    break;
                case "name":
                    map.put("name",major.getName());
                    break;
                case "phone":
                    map.put("phone", major.getPhone());
                    break;
            }
        }
        return map;
    }
}
