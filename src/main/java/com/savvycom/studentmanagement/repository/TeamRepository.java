package com.savvycom.studentmanagement.repository;

import com.savvycom.studentmanagement.repository.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
