-- Insert sample data for Home Loan EDMS
INSERT INTO HOME_LOAN_EDMS (cif, accountNumber, docId, referenceId, documentType, uploadDate, status) VALUES
('CIF001', 'HL001', 'DOC-HL-001', 'REF-HL-001', 'Income Proof', '2024-01-15', 'Approved'),
('CIF001', 'HL001', 'DOC-HL-002', 'REF-HL-002', 'Property Documents', '2024-01-16', 'Approved'),
('CIF002', 'HL002', 'DOC-HL-003', 'REF-HL-003', 'Identity Proof', '2024-01-20', 'Pending'),
('CIF003', 'HL003', 'DOC-HL-004', 'REF-HL-004', 'Bank Statement', '2024-02-01', 'Approved'),
('CIF004', 'HL004', 'DOC-HL-005', 'REF-HL-005', 'Salary Slip', '2024-02-10', 'Rejected'),
('CIF005', 'HL005', 'DOC-HL-006', 'REF-HL-006', 'Property Valuation', '2024-02-15', 'Approved'),
('CIF006', 'HL006', 'DOC-HL-007', 'REF-HL-007', 'Tax Returns', '2024-03-01', 'Approved'),
('CIF007', 'HL007', 'DOC-HL-008', 'REF-HL-008', 'Employment Letter', '2024-03-05', 'Pending'),
('CIF008', 'HL008', 'DOC-HL-009', 'REF-HL-009', 'Credit Report', '2024-03-10', 'Approved'),
('CIF009', 'HL009', 'DOC-HL-010', 'REF-HL-010', 'Insurance Documents', '2024-03-15', 'Approved');

-- Insert sample data for Personal Loan EDMS
INSERT INTO PERSONAL_LOAN_EDMS (cif, accountNumber, docId, referenceId, documentType, uploadDate, status) VALUES
('CIF010', 'PL001', 'DOC-PL-001', 'REF-PL-001', 'Identity Proof', '2024-01-10', 'Approved'),
('CIF011', 'PL002', 'DOC-PL-002', 'REF-PL-002', 'Income Proof', '2024-01-12', 'Approved'),
('CIF012', 'PL003', 'DOC-PL-003', 'REF-PL-003', 'Bank Statement', '2024-01-18', 'Pending'),
('CIF013', 'PL004', 'DOC-PL-004', 'REF-PL-004', 'Address Proof', '2024-02-05', 'Approved'),
('CIF014', 'PL005', 'DOC-PL-005', 'REF-PL-005', 'Salary Slip', '2024-02-12', 'Approved'),
('CIF015', 'PL006', 'DOC-PL-006', 'REF-PL-006', 'Employment Letter', '2024-02-20', 'Rejected'),
('CIF016', 'PL007', 'DOC-PL-007', 'REF-PL-007', 'PAN Card', '2024-03-02', 'Approved'),
('CIF017', 'PL008', 'DOC-PL-008', 'REF-PL-008', 'Aadhaar Card', '2024-03-08', 'Approved'),
('CIF018', 'PL009', 'DOC-PL-009', 'REF-PL-009', 'Form 16', '2024-03-12', 'Pending'),
('CIF019', 'PL010', 'DOC-PL-010', 'REF-PL-010', 'Credit Report', '2024-03-18', 'Approved');

-- Insert sample data for Auto Loan EDMS
INSERT INTO AUTO_LOAN_EDMS (cif, accountNumber, docId, referenceId, documentType, uploadDate, status) VALUES
('CIF020', 'AL001', 'DOC-AL-001', 'REF-AL-001', 'Vehicle Invoice', '2024-01-08', 'Approved'),
('CIF021', 'AL002', 'DOC-AL-002', 'REF-AL-002', 'Identity Proof', '2024-01-14', 'Approved'),
('CIF022', 'AL003', 'DOC-AL-003', 'REF-AL-003', 'Income Proof', '2024-01-22', 'Pending'),
('CIF023', 'AL004', 'DOC-AL-004', 'REF-AL-004', 'Driving License', '2024-02-03', 'Approved'),
('CIF024', 'AL005', 'DOC-AL-005', 'REF-AL-005', 'Insurance Quote', '2024-02-14', 'Approved'),
('CIF025', 'AL006', 'DOC-AL-006', 'REF-AL-006', 'Bank Statement', '2024-02-22', 'Approved'),
('CIF026', 'AL007', 'DOC-AL-007', 'REF-AL-007', 'Address Proof', '2024-03-04', 'Rejected'),
('CIF027', 'AL008', 'DOC-AL-008', 'REF-AL-008', 'Salary Slip', '2024-03-09', 'Approved'),
('CIF028', 'AL009', 'DOC-AL-009', 'REF-AL-009', 'Vehicle Registration', '2024-03-14', 'Pending'),
('CIF029', 'AL010', 'DOC-AL-010', 'REF-AL-010', 'Down Payment Receipt', '2024-03-20', 'Approved');

-- Insert sample data for Credit Card EDMS
INSERT INTO CREDIT_CARD_EDMS (cif, accountNumber, docId, referenceId, documentType, uploadDate, status) VALUES
('CIF030', 'CC001', 'DOC-CC-001', 'REF-CC-001', 'Identity Proof', '2024-01-05', 'Approved'),
('CIF031', 'CC002', 'DOC-CC-002', 'REF-CC-002', 'Income Proof', '2024-01-11', 'Approved'),
('CIF032', 'CC003', 'DOC-CC-003', 'REF-CC-003', 'Address Proof', '2024-01-19', 'Pending'),
('CIF033', 'CC004', 'DOC-CC-004', 'REF-CC-004', 'Bank Statement', '2024-02-02', 'Approved'),
('CIF034', 'CC005', 'DOC-CC-005', 'REF-CC-005', 'Salary Slip', '2024-02-11', 'Approved'),
('CIF035', 'CC006', 'DOC-CC-006', 'REF-CC-006', 'PAN Card', '2024-02-18', 'Approved'),
('CIF036', 'CC007', 'DOC-CC-007', 'REF-CC-007', 'Form 16', '2024-03-03', 'Rejected'),
('CIF037', 'CC008', 'DOC-CC-008', 'REF-CC-008', 'Credit Report', '2024-03-07', 'Approved'),
('CIF038', 'CC009', 'DOC-CC-009', 'REF-CC-009', 'Employment Letter', '2024-03-13', 'Approved'),
('CIF039', 'CC010', 'DOC-CC-010', 'REF-CC-010', 'Passport Copy', '2024-03-19', 'Pending');

-- Insert sample data for Business Loan EDMS
INSERT INTO BUSINESS_LOAN_EDMS (cif, accountNumber, docId, referenceId, documentType, uploadDate, status) VALUES
('CIF040', 'BL001', 'DOC-BL-001', 'REF-BL-001', 'Business Registration', '2024-01-07', 'Approved'),
('CIF041', 'BL002', 'DOC-BL-002', 'REF-BL-002', 'GST Certificate', '2024-01-13', 'Approved'),
('CIF042', 'BL003', 'DOC-BL-003', 'REF-BL-003', 'Financial Statements', '2024-01-21', 'Pending'),
('CIF043', 'BL004', 'DOC-BL-004', 'REF-BL-004', 'Tax Returns', '2024-02-04', 'Approved'),
('CIF044', 'BL005', 'DOC-BL-005', 'REF-BL-005', 'Bank Statement', '2024-02-13', 'Approved'),
('CIF045', 'BL006', 'DOC-BL-006', 'REF-BL-006', 'Business Plan', '2024-02-21', 'Approved'),
('CIF046', 'BL007', 'DOC-BL-007', 'REF-BL-007', 'Property Documents', '2024-03-06', 'Rejected'),
('CIF047', 'BL008', 'DOC-BL-008', 'REF-BL-008', 'Partnership Deed', '2024-03-11', 'Approved'),
('CIF048', 'BL009', 'DOC-BL-009', 'REF-BL-009', 'Trade License', '2024-03-16', 'Pending'),
('CIF049', 'BL010', 'DOC-BL-010', 'REF-BL-010', 'Collateral Documents', '2024-03-21', 'Approved');

-- Insert additional records to test pagination (more than 100 records)
-- Adding more Home Loan records
INSERT INTO HOME_LOAN_EDMS (cif, accountNumber, docId, referenceId, documentType, uploadDate, status)
SELECT 
    CONCAT('CIF', LPAD(CAST(50 + ROWNUM() AS VARCHAR), 3, '0')),
    CONCAT('HL', LPAD(CAST(11 + ROWNUM() AS VARCHAR), 3, '0')),
    CONCAT('DOC-HL-', LPAD(CAST(11 + ROWNUM() AS VARCHAR), 3, '0')),
    CONCAT('REF-HL-', LPAD(CAST(11 + ROWNUM() AS VARCHAR), 3, '0')),
    CASE MOD(ROWNUM(), 5)
        WHEN 0 THEN 'Income Proof'
        WHEN 1 THEN 'Property Documents'
        WHEN 2 THEN 'Bank Statement'
        WHEN 3 THEN 'Identity Proof'
        ELSE 'Tax Returns'
    END,
    DATEADD('DAY', ROWNUM(), '2024-03-20'),
    CASE MOD(ROWNUM(), 3)
        WHEN 0 THEN 'Approved'
        WHEN 1 THEN 'Pending'
        ELSE 'Rejected'
    END
FROM SYSTEM_RANGE(1, 100);

-- Made with Bob
