package com.edms.controller;

import com.edms.config.JourneyConfiguration;
import com.edms.dto.SearchRequest;
import com.edms.dto.SearchResponse;
import com.edms.service.EdmsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EdmsSearchController {

    @Autowired
    private EdmsSearchService edmsSearchService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("journeys", edmsSearchService.getAvailableJourneys());
        model.addAttribute("searchRequest", new SearchRequest());
        return "index";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute SearchRequest searchRequest, 
                        @RequestParam(defaultValue = "0") int page,
                        Model model) {
        
        searchRequest.setPage(page);
        
        SearchResponse response = edmsSearchService.search(searchRequest);
        
        model.addAttribute("journeys", edmsSearchService.getAvailableJourneys());
        model.addAttribute("searchRequest", searchRequest);
        model.addAttribute("response", response);
        
        // Add column names for table header
        if (response.getRecords() != null && !response.getRecords().isEmpty()) {
            model.addAttribute("columns", response.getRecords().get(0).keySet());
        } else if (searchRequest.getJourneyName() != null && !searchRequest.getJourneyName().isEmpty()) {
            // Get columns from config even if no records found
            JourneyConfiguration.JourneyConfig config = edmsSearchService.getJourneyConfig(searchRequest.getJourneyName());
            if (config != null) {
                model.addAttribute("columns", config.getColumns());
            }
        }
        
        return "index";
    }
}

// Made with Bob
