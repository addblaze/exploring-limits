package com.edms.service;

import com.edms.config.JourneyConfiguration;
import com.edms.dto.SearchRequest;
import com.edms.dto.SearchResponse;
import com.edms.repository.EdmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EdmsSearchService {

    @Autowired
    private EdmsRepository edmsRepository;

    @Autowired
    private JourneyConfiguration journeyConfiguration;

    public List<String> getAvailableJourneys() {
        return journeyConfiguration.getAvailable();
    }

    public SearchResponse search(SearchRequest request) {
        try {
            // Validate journey name
            if (request.getJourneyName() == null || request.getJourneyName().trim().isEmpty()) {
                SearchResponse response = new SearchResponse();
                response.setMessage("Please select a journey");
                return response;
            }

            // Validate search criteria
            if (!request.hasSearchCriteria()) {
                SearchResponse response = new SearchResponse();
                response.setMessage("Please provide at least one search criteria");
                return response;
            }

            // Get total count
            long totalRecords = edmsRepository.countRecords(request);

            if (totalRecords == 0) {
                SearchResponse response = new SearchResponse();
                response.setMessage("No records found for the given search criteria");
                response.setTotalRecords(0);
                response.setCurrentPage(request.getPage());
                response.setPageSize(request.getSize());
                return response;
            }

            // Get records
            List<Map<String, Object>> records = edmsRepository.searchRecords(request);

            // Create response
            SearchResponse response = new SearchResponse(records, totalRecords, request.getPage(), request.getSize());
            
            if (records.isEmpty()) {
                response.setMessage("No records found on this page");
            }

            return response;

        } catch (Exception e) {
            SearchResponse response = new SearchResponse();
            response.setMessage("Error occurred while searching: " + e.getMessage());
            return response;
        }
    }

    public JourneyConfiguration.JourneyConfig getJourneyConfig(String journeyName) {
        return journeyConfiguration.getJourneyConfig(journeyName);
    }
}

// Made with Bob
