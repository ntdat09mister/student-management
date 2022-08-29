package com.savvycom.studentmanagement.repository;

import com.savvycom.studentmanagement.domain.entity.Lecturer;
import com.savvycom.studentmanagement.domain.dto.LecturerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecturer, Long> {
    @Query(value = "select l.id as id, l.name as name, mj.name as majorName from lecturer l join major mj on (l.major_id = mj.id)", nativeQuery = true)
    List<LecturerDTO> getListLecturer();
    @Query(value = "select lt.id as id, lt.name as name, mj.name as majorName from lecturer lt join major mj on" +
            " lt.major_id = mj.id where mj.name in (:majorName) " ,nativeQuery = true)
    List<LecturerDTO> getListByMajorName(@Param("majorName") List<String> majorName);
    @Query(value = "select count( lt.id ) from lecturer lt join major mj on lt.major_id=mj.id where mj.name in (:majorNames)",nativeQuery = true)
    Long countByMajorName(@Param("majorNames") List<String> majorNames);
    @Query(value = "select lt.id as id,lt.name as name,mj.name as majorName from lecturer lt join major mj on lt.major_id=mj.id join" +
            "(select mj.id,mj.name,count(st.id) as countStd from student st join major mj on st.major_id=mj.id group by mj.name) as table1 on mj.id=table1.id " +
            "where countStd > (:NumberStd)",nativeQuery = true)
    List<LecturerDTO> getLecturerTutoMore3Std(Long NumberStd);
}
