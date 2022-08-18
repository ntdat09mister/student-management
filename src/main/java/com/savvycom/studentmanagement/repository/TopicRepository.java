package com.savvycom.studentmanagement.repository;

import com.savvycom.studentmanagement.repository.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
