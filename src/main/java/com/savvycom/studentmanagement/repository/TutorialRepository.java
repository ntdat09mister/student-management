package com.savvycom.studentmanagement.repository;

import com.savvycom.studentmanagement.repository.domain.Tutorial;
import com.savvycom.studentmanagement.repository.dto.TutorialDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Tutorial.PK> {
    @Query(value = "Select tt.student_id as StudentId, tt.score as Score, tt.lecturer_id as LecturerId, tt.team_id as teamId, " +
            "tt.topic_id as TopicId, st.name as name from tutorial tt left join student st on tt.student_id=st.id  ",nativeQuery = true)
    List<TutorialDTO> getShowTutorial();
    @Query(value = "Select tt.student_id as StudentId, tt.score as Score, tt.lecturer_id as LecturerId, tt.team_id as" +
            " teamId, tt.topic_id as TopicId, st.name as StudentName from tutorial tt right join student st on tt.student_id=st.id",nativeQuery = true)
    List<TutorialDTO> getStudentAndPoint();
    @Query(value = "select tt.team_id as TeamId ,count(tt.student_id) as ScoreAbove5  from tutorial tt where tt.score>5 group by tt.team_id order by tt.team_id",nativeQuery = true)
    List<TutorialDTO> getScoreAbove5OfTeam();
}
