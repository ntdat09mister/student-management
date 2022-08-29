package com.savvycom.studentmanagement.repository.impl;

import com.savvycom.studentmanagement.domain.entity.Lecturer;
import com.savvycom.studentmanagement.repository.EntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class LecturerRepositoryImpl extends EntityRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public Page<Lecturer> getLecturerCon(String firstDay,String lastDay, Integer offset, Integer limit,String sort,List<String> sortBy, PageRequest pageRequest){
        StringBuilder sqlWhere = new StringBuilder();
        Map<String,Object> params = new HashMap<>();
        sqlWhere.append(" AND l.updated_at > :firstDay");
        params.put("firstDay", firstDay);
        sqlWhere.append(" AND l.updated_at < :lastDay");
        params.put("lastDay", lastDay);
        StringBuilder sqlLimit = new StringBuilder();
        if(sort!=null&&!sort.equalsIgnoreCase("asc")){
            sort="desc";
        }else {
            sort="asc";
        }
        if(!CollectionUtils.isEmpty(sortBy)){
            sqlLimit.append(" order by ");
            for(int i=0;i<sortBy.size();i++){
                if(i!=0){
                    sqlLimit.append(",");
                }
                sqlLimit.append(sortBy.get(i));
                sqlLimit.append(" ");
                sqlLimit.append(sort);
            }
            String sqlQuery = "Select * from lecturer l where 1=1 " + sqlWhere + sqlLimit;
            String sqlCountQuery = "Select count(*) from lecturer l where 1=1 " + sqlWhere;
            Query query = entityManager.createNativeQuery(sqlQuery,Lecturer.class);
            query.setMaxResults(limit);
            query.setFirstResult(offset);
            Query countQuery = entityManager.createNativeQuery(sqlCountQuery);
            if (params != null) {
                params.entrySet().forEach(entry -> {
                    query.setParameter(entry.getKey(), entry.getValue());
                    countQuery.setParameter(entry.getKey(), entry.getValue());
                });
                BigInteger total = (BigInteger) countQuery.getSingleResult();
                return new PageImpl<Lecturer>(query.getResultList(), pageRequest, total.longValue());
            }
        }
        return null;
    }
}
