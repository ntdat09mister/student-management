package com.savvycom.studentmanagement.repository;

import com.savvycom.studentmanagement.domain.entity.Major;
import com.savvycom.studentmanagement.domain.dto.MajorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorRepository extends JpaRepository<Major,Long> {
    @Query(value = "select mj.name as NameMajor,count(st.id) as CountStd from major mj left join student st on mj.id=st.major_id group by mj.name",nativeQuery = true)
    List<MajorDTO> countStdPerMajor();

}
