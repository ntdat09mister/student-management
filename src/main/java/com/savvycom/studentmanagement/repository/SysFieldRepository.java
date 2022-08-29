package com.savvycom.studentmanagement.repository;

import com.savvycom.studentmanagement.domain.entity.SysField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysFieldRepository extends JpaRepository<SysField,Long> {
    @Query("select sf.fieldName from SysField sf where sf.tableName = 'major' and sf.columnIndex >0")
    List<String> findField();
    @Query("SELECT sf FROM SysField sf WHERE sf.tableName = 'major' and sf.columnIndex > 0")
    List<SysField> findToGetById();
}
