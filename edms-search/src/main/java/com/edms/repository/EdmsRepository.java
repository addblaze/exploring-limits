package com.edms.repository;

import com.edms.config.JourneyConfiguration;
import com.edms.dto.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class EdmsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JourneyConfiguration journeyConfiguration;

    public List<Map<String, Object>> searchRecords(SearchRequest request) {
        JourneyConfiguration.JourneyConfig config = journeyConfiguration.getJourneyConfig(request.getJourneyName());
        
        if (config == null) {
            throw new IllegalArgumentException("Invalid journey name: " + request.getJourneyName());
        }

        StringBuilder sql = new StringBuilder("SELECT ");
        
        // Add columns
        List<String> columns = config.getColumns();
        for (int i = 0; i < columns.size(); i++) {
            sql.append(columns.get(i));
            if (i < columns.size() - 1) {
                sql.append(", ");
            }
        }
        
        sql.append(" FROM ").append(config.getTable());
        
        // Build WHERE clause using configurable column names
        List<Object> params = new ArrayList<>();
        StringBuilder whereClause = new StringBuilder();
        
        if (request.getCif() != null && !request.getCif().trim().isEmpty()) {
            addWhereCondition(whereClause, config.getMappedColumn("cif") + " = ?");
            params.add(request.getCif().trim());
        }
        
        if (request.getAccountNumber() != null && !request.getAccountNumber().trim().isEmpty()) {
            addWhereCondition(whereClause, config.getMappedColumn("accountNumber") + " = ?");
            params.add(request.getAccountNumber().trim());
        }
        
        if (request.getDocId() != null && !request.getDocId().trim().isEmpty()) {
            addWhereCondition(whereClause, config.getMappedColumn("docId") + " = ?");
            params.add(request.getDocId().trim());
        }
        
        if (request.getReferenceId() != null && !request.getReferenceId().trim().isEmpty()) {
            addWhereCondition(whereClause, config.getMappedColumn("referenceId") + " = ?");
            params.add(request.getReferenceId().trim());
        }
        
        if (request.getFromDate() != null && !request.getFromDate().trim().isEmpty()) {
            addWhereCondition(whereClause, config.getMappedColumn("uploadDate") + " >= ?");
            params.add(request.getFromDate().trim());
        }
        
        if (request.getToDate() != null && !request.getToDate().trim().isEmpty()) {
            addWhereCondition(whereClause, config.getMappedColumn("uploadDate") + " <= ?");
            params.add(request.getToDate().trim());
        }
        
        if (whereClause.length() > 0) {
            sql.append(" WHERE ").append(whereClause);
        }
        
        // Add pagination
        sql.append(" LIMIT ? OFFSET ?");
        params.add(request.getSize());
        params.add(request.getPage() * request.getSize());
        
        return jdbcTemplate.queryForList(sql.toString(), params.toArray());
    }

    public long countRecords(SearchRequest request) {
        JourneyConfiguration.JourneyConfig config = journeyConfiguration.getJourneyConfig(request.getJourneyName());
        
        if (config == null) {
            throw new IllegalArgumentException("Invalid journey name: " + request.getJourneyName());
        }

        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM ").append(config.getTable());
        
        // Build WHERE clause using configurable column names
        List<Object> params = new ArrayList<>();
        StringBuilder whereClause = new StringBuilder();
        
        if (request.getCif() != null && !request.getCif().trim().isEmpty()) {
            addWhereCondition(whereClause, config.getMappedColumn("cif") + " = ?");
            params.add(request.getCif().trim());
        }
        
        if (request.getAccountNumber() != null && !request.getAccountNumber().trim().isEmpty()) {
            addWhereCondition(whereClause, config.getMappedColumn("accountNumber") + " = ?");
            params.add(request.getAccountNumber().trim());
        }
        
        if (request.getDocId() != null && !request.getDocId().trim().isEmpty()) {
            addWhereCondition(whereClause, config.getMappedColumn("docId") + " = ?");
            params.add(request.getDocId().trim());
        }
        
        if (request.getReferenceId() != null && !request.getReferenceId().trim().isEmpty()) {
            addWhereCondition(whereClause, config.getMappedColumn("referenceId") + " = ?");
            params.add(request.getReferenceId().trim());
        }
        
        if (request.getFromDate() != null && !request.getFromDate().trim().isEmpty()) {
            addWhereCondition(whereClause, config.getMappedColumn("uploadDate") + " >= ?");
            params.add(request.getFromDate().trim());
        }
        
        if (request.getToDate() != null && !request.getToDate().trim().isEmpty()) {
            addWhereCondition(whereClause, config.getMappedColumn("uploadDate") + " <= ?");
            params.add(request.getToDate().trim());
        }
        
        if (whereClause.length() > 0) {
            sql.append(" WHERE ").append(whereClause);
        }
        
        Long count = jdbcTemplate.queryForObject(sql.toString(), params.toArray(), Long.class);
        return count != null ? count : 0L;
    }

    private void addWhereCondition(StringBuilder whereClause, String condition) {
        if (whereClause.length() > 0) {
            whereClause.append(" AND ");
        }
        whereClause.append(condition);
    }
}

// Made with Bob
