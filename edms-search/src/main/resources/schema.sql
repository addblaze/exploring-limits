-- Drop tables if they exist
DROP TABLE IF EXISTS HOME_LOAN_EDMS;
DROP TABLE IF EXISTS PERSONAL_LOAN_EDMS;
DROP TABLE IF EXISTS AUTO_LOAN_EDMS;
DROP TABLE IF EXISTS CREDIT_CARD_EDMS;
DROP TABLE IF EXISTS BUSINESS_LOAN_EDMS;

-- Create Home Loan EDMS Table
CREATE TABLE HOME_LOAN_EDMS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cif VARCHAR(50) NOT NULL,
    accountNumber VARCHAR(50) NOT NULL,
    docId VARCHAR(100) NOT NULL,
    referenceId VARCHAR(100),
    documentType VARCHAR(100),
    uploadDate DATE,
    status VARCHAR(50)
);

-- Create Personal Loan EDMS Table
CREATE TABLE PERSONAL_LOAN_EDMS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cif VARCHAR(50) NOT NULL,
    accountNumber VARCHAR(50) NOT NULL,
    docId VARCHAR(100) NOT NULL,
    referenceId VARCHAR(100),
    documentType VARCHAR(100),
    uploadDate DATE,
    status VARCHAR(50)
);

-- Create Auto Loan EDMS Table
CREATE TABLE AUTO_LOAN_EDMS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cif VARCHAR(50) NOT NULL,
    accountNumber VARCHAR(50) NOT NULL,
    docId VARCHAR(100) NOT NULL,
    referenceId VARCHAR(100),
    documentType VARCHAR(100),
    uploadDate DATE,
    status VARCHAR(50)
);

-- Create Credit Card EDMS Table
CREATE TABLE CREDIT_CARD_EDMS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cif VARCHAR(50) NOT NULL,
    accountNumber VARCHAR(50) NOT NULL,
    docId VARCHAR(100) NOT NULL,
    referenceId VARCHAR(100),
    documentType VARCHAR(100),
    uploadDate DATE,
    status VARCHAR(50)
);

-- Create Business Loan EDMS Table
CREATE TABLE BUSINESS_LOAN_EDMS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cif VARCHAR(50) NOT NULL,
    accountNumber VARCHAR(50) NOT NULL,
    docId VARCHAR(100) NOT NULL,
    referenceId VARCHAR(100),
    documentType VARCHAR(100),
    uploadDate DATE,
    status VARCHAR(50)
);

-- Create indexes for better search performance
CREATE INDEX idx_home_loan_cif ON HOME_LOAN_EDMS(cif);
CREATE INDEX idx_home_loan_account ON HOME_LOAN_EDMS(accountNumber);
CREATE INDEX idx_home_loan_docid ON HOME_LOAN_EDMS(docId);
CREATE INDEX idx_home_loan_refid ON HOME_LOAN_EDMS(referenceId);

CREATE INDEX idx_personal_loan_cif ON PERSONAL_LOAN_EDMS(cif);
CREATE INDEX idx_personal_loan_account ON PERSONAL_LOAN_EDMS(accountNumber);
CREATE INDEX idx_personal_loan_docid ON PERSONAL_LOAN_EDMS(docId);
CREATE INDEX idx_personal_loan_refid ON PERSONAL_LOAN_EDMS(referenceId);

CREATE INDEX idx_auto_loan_cif ON AUTO_LOAN_EDMS(cif);
CREATE INDEX idx_auto_loan_account ON AUTO_LOAN_EDMS(accountNumber);
CREATE INDEX idx_auto_loan_docid ON AUTO_LOAN_EDMS(docId);
CREATE INDEX idx_auto_loan_refid ON AUTO_LOAN_EDMS(referenceId);

CREATE INDEX idx_credit_card_cif ON CREDIT_CARD_EDMS(cif);
CREATE INDEX idx_credit_card_account ON CREDIT_CARD_EDMS(accountNumber);
CREATE INDEX idx_credit_card_docid ON CREDIT_CARD_EDMS(docId);
CREATE INDEX idx_credit_card_refid ON CREDIT_CARD_EDMS(referenceId);

CREATE INDEX idx_business_loan_cif ON BUSINESS_LOAN_EDMS(cif);
CREATE INDEX idx_business_loan_account ON BUSINESS_LOAN_EDMS(accountNumber);
CREATE INDEX idx_business_loan_docid ON BUSINESS_LOAN_EDMS(docId);
CREATE INDEX idx_business_loan_refid ON BUSINESS_LOAN_EDMS(referenceId);

-- Made with Bob
