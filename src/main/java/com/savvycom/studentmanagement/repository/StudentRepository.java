package com.savvycom.studentmanagement.repository;

import com.savvycom.studentmanagement.repository.domain.Student;
import com.savvycom.studentmanagement.repository.dto.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select std.id as id, std.name as name, t.name as topicName, tu.score as score from student std " +
            "left join tutorial tu on (std.id = tu.student_id) " +
            "left join topic t on (tu.topic_id = t.id) " +
            "where std.major_id = :majorId", nativeQuery = true)
    List<StudentDTO> getByMajorId(@Param("majorId") Long majorId);
    @Query(value = "Select count(st.id) from student st join major mj on st.major_id = mj.id  where mj.name in (:majorNames) ",nativeQuery = true)
    Long countByMajorName(List<String> majorNames);
    @Query(value = "Select st.id as id,st.name as name, year(curdate())-year(st.birthday) as age from student st join major mj " +
            "on st.major_id=mj.id where mj.name in (:majorNames)",nativeQuery = true)

    List<StudentDTO> getStudentByMajorName(@Param("majorNames") List<String> majorNames);
    @Query(value = "select st.id as id, st.name as name, st.birthday as birthday from student st where st.id not in" +
            "(select tt.student_id as student_id from tutorial tt)",nativeQuery = true)
    List<StudentDTO> getStdNotDoTopic();
    @Query(value = "select st.id as id, st.name as name from student st join tutorial tt on st.id=tt.student_id where tt.score in (:score)",nativeQuery = true)
    List<StudentDTO> getStudentScoreZero(@Param("score") Double score);
    @Query(value = "select st.id as id, st.name as name , tt.score as score from student st join tutorial tt on " +
            "st.id=tt.student_id where st.major_id=1 order by tt.score desc limit 5", nativeQuery = true)
    List<StudentDTO> getTop5Score();
}
