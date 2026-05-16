package com.edms.dto;

public class SearchRequest {

    private String journeyName;
    private String cif;
    private String docId;
    private String referenceId;
    private String accountNumber;
    private String fromDate;
    private String toDate;
    private int page = 0;
    private int size = 100;

    public SearchRequest() {
    }

    public String getJourneyName() {
        return journeyName;
    }

    public void setJourneyName(String journeyName) {
        this.journeyName = journeyName;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean hasSearchCriteria() {
        return (cif != null && !cif.trim().isEmpty()) ||
               (docId != null && !docId.trim().isEmpty()) ||
               (referenceId != null && !referenceId.trim().isEmpty()) ||
               (accountNumber != null && !accountNumber.trim().isEmpty());
    }
}

// Made with Bob
