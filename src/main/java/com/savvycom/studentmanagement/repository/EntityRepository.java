package com.savvycom.studentmanagement.repository;

import java.math.BigInteger;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public abstract class EntityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    protected <T> Page<T> fetchPaging(String sqlQuery, String sqlCountQuery, Map<String, Object> params, Class<T> clazz,
                                      PageRequest pageRequest) {
        Query query = entityManager.createNativeQuery(sqlQuery, clazz);
        query.setMaxResults(pageRequest.getPageSize());
        query.setFirstResult(pageRequest.getPageNumber() * pageRequest.getPageSize());
        Query countQuery = entityManager.createNativeQuery(sqlCountQuery);
        if (params != null) {
            params.entrySet().forEach(entry -> {
                query.setParameter(entry.getKey(), entry.getValue());
                countQuery.setParameter(entry.getKey(), entry.getValue());
            });
        }
        BigInteger total = (BigInteger) countQuery.getSingleResult();
        return new PageImpl<T>(query.getResultList(), pageRequest, total.longValue());
    }
}
