package com.edms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
@ConfigurationProperties(prefix = "journey")
public class JourneyConfiguration {

    // Spring Boot will automatically map journey.homeLoan.* to this map with key "homeLoan"
    private Map<String, JourneyConfig> journeys = new HashMap<>();
    private List<String> available = new ArrayList<>();

    // Getter for homeLoan, personalLoan, etc. - Spring uses this to populate the map
    public JourneyConfig getHomeLoan() {
        return journeys.get("homeLoan");
    }

    public void setHomeLoan(JourneyConfig config) {
        journeys.put("homeLoan", config);
    }

    public JourneyConfig getPersonalLoan() {
        return journeys.get("personalLoan");
    }

    public void setPersonalLoan(JourneyConfig config) {
        journeys.put("personalLoan", config);
    }

    public JourneyConfig getAutoLoan() {
        return journeys.get("autoLoan");
    }

    public void setAutoLoan(JourneyConfig config) {
        journeys.put("autoLoan", config);
    }

    public JourneyConfig getCreditCard() {
        return journeys.get("creditCard");
    }

    public void setCreditCard(JourneyConfig config) {
        journeys.put("creditCard", config);
    }

    public JourneyConfig getBusinessLoan() {
        return journeys.get("businessLoan");
    }

    public void setBusinessLoan(JourneyConfig config) {
        journeys.put("businessLoan", config);
    }

    public Map<String, JourneyConfig> getJourneys() {
        return journeys;
    }

    public void setJourneys(Map<String, JourneyConfig> journeys) {
        this.journeys = journeys;
    }

    public List<String> getAvailable() {
        return available;
    }

    public void setAvailable(List<String> available) {
        this.available = available;
    }

    public JourneyConfig getJourneyConfig(String journeyName) {
        return journeys.get(journeyName);
    }

    public static class JourneyConfig {
        private String table;
        private List<String> columns = new ArrayList<>();
        private List<String> searchColumns = new ArrayList<>();
        private Map<String, String> columnMapping = new HashMap<>();

        public String getTable() {
            return table;
        }

        public void setTable(String table) {
            this.table = table;
        }

        public List<String> getColumns() {
            return columns;
        }

        public void setColumns(String columns) {
            if (columns != null && !columns.isEmpty()) {
                this.columns = Arrays.asList(columns.split(","));
            }
        }

        public List<String> getSearchColumns() {
            return searchColumns;
        }

        public void setSearchColumns(String searchColumns) {
            if (searchColumns != null && !searchColumns.isEmpty()) {
                this.searchColumns = Arrays.asList(searchColumns.split(","));
            }
        }

        public Map<String, String> getColumnMapping() {
            return columnMapping;
        }

        public void setColumnMapping(Map<String, String> columnMapping) {
            this.columnMapping = columnMapping;
        }

        /**
         * Get the actual database column name for a logical field name
         * @param logicalName The logical field name (e.g., "cif", "accountNumber")
         * @return The actual database column name, or the logical name if no mapping exists
         */
        public String getMappedColumn(String logicalName) {
            return columnMapping.getOrDefault(logicalName, logicalName);
        }
    }
}

// Made with Bob
