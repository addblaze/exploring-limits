# Quick Start Guide - EDMS Search Application

## Prerequisites

Before running the application, ensure you have:

1. **JDK 1.8** installed and configured
   - Verify: `java -version`
   - Should show version 1.8.x

2. **Maven** installed and in PATH
   - Verify: `mvn -version`
   - Download from: https://maven.apache.org/download.cgi

## Running the Application

### Option 1: Using Run Scripts (Recommended)

**Windows:**
```bash
run.bat
```

**Linux/Mac:**
```bash
chmod +x run.sh
./run.sh
```

### Option 2: Manual Maven Commands

1. **Build the project:**
   ```bash
   mvn clean package -DskipTests
   ```

2. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

### Option 3: Run JAR directly

1. **Build the JAR:**
   ```bash
   mvn clean package -DskipTests
   ```

2. **Run the JAR:**
   ```bash
   java -jar target/edms-search-1.0.0.jar
   ```

## Accessing the Application

Once the application starts successfully, you'll see:

```
Started EdmsSearchApplication in X.XXX seconds
```

### Main Application
- **URL:** http://localhost:8080
- **Description:** EDMS Search Interface

### H2 Database Console
- **URL:** http://localhost:8080/h2-console
- **JDBC URL:** jdbc:h2:mem:edmsdb
- **Username:** sa
- **Password:** (leave empty)

## Using the Application

### Step 1: Select Journey
Choose from available journeys:
- Home Loan
- Personal Loan
- Auto Loan
- Credit Card
- Business Loan

### Step 2: Enter Search Criteria
Provide at least one of the following:
- **CIF Number:** Customer Information File number
- **Account Number:** Account identifier
- **Document ID:** Document identifier
- **Reference ID:** Reference identifier
- **Date Range:** From Date and To Date (optional)

### Step 3: Search
Click the "Search" button to retrieve results.

### Step 4: View Results
- Results are displayed in a table format
- Maximum 100 records per page
- Use pagination buttons to navigate through results

## Sample Search Queries

Try these sample queries to test the application:

### Home Loan Searches
```
Journey: Home Loan
CIF: CIF001
```

```
Journey: Home Loan
Account Number: HL001
```

```
Journey: Home Loan
Document ID: DOC-HL-001
```

### Personal Loan Searches
```
Journey: Personal Loan
CIF: CIF010
```

```
Journey: Personal Loan
Account Number: PL001
```

### Testing Pagination
```
Journey: Home Loan
CIF: CIF050 to CIF149 (will return 100+ records)
```

## Troubleshooting

### Issue: Port 8080 already in use

**Solution:** Change the port in `src/main/resources/application.properties`
```properties
server.port=8081
```

### Issue: Maven not found

**Solution:** 
1. Download Maven from https://maven.apache.org/download.cgi
2. Extract to a directory (e.g., C:\apache-maven-3.x.x)
3. Add to PATH:
   - Windows: Add `C:\apache-maven-3.x.x\bin` to System PATH
   - Linux/Mac: Add `export PATH=/path/to/maven/bin:$PATH` to ~/.bashrc or ~/.zshrc

### Issue: Java version mismatch

**Solution:** Ensure JDK 1.8 is installed and JAVA_HOME is set correctly
```bash
# Windows
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_xxx
set PATH=%JAVA_HOME%\bin;%PATH%

# Linux/Mac
export JAVA_HOME=/path/to/jdk1.8.0_xxx
export PATH=$JAVA_HOME/bin:$PATH
```

### Issue: Application fails to start

**Solution:** Check the console logs for errors. Common issues:
1. Port already in use
2. Database initialization failed
3. Missing dependencies

### Issue: No records found

**Solution:**
1. Verify journey is selected
2. Ensure at least one search criteria is provided
3. Check H2 console to verify data is loaded
4. Try sample queries listed above

## Stopping the Application

Press `Ctrl + C` in the terminal where the application is running.

## Database Inspection

To inspect the database:

1. Access H2 Console: http://localhost:8080/h2-console
2. Use connection details:
   - JDBC URL: `jdbc:h2:mem:edmsdb`
   - Username: `sa`
   - Password: (empty)
3. Run SQL queries to inspect data:
   ```sql
   SELECT * FROM HOME_LOAN_EDMS;
   SELECT COUNT(*) FROM HOME_LOAN_EDMS;
   ```

## Adding New Journey

To add a new journey without code changes:

1. **Update application.properties:**
   ```properties
   journey.available=homeLoan,personalLoan,autoLoan,creditCard,businessLoan,newJourney
   
   journey.newJourney.table=NEW_JOURNEY_EDMS
   journey.newJourney.columns=id,cif,accountNumber,docId,referenceId,documentType,uploadDate,status
   journey.newJourney.searchColumns=cif,accountNumber,docId,referenceId
   ```

2. **Update schema.sql:**
   ```sql
   CREATE TABLE NEW_JOURNEY_EDMS (
       id BIGINT AUTO_INCREMENT PRIMARY KEY,
       cif VARCHAR(50) NOT NULL,
       accountNumber VARCHAR(50) NOT NULL,
       docId VARCHAR(100) NOT NULL,
       referenceId VARCHAR(100),
       documentType VARCHAR(100),
       uploadDate DATE,
       status VARCHAR(50)
   );
   ```

3. **Restart the application**

## Next Steps

- Explore different search combinations
- Test pagination with large result sets
- Inspect database using H2 console
- Add custom journeys as needed
- Customize UI styling in `templates/index.html`

## Support

For issues or questions:
1. Check the main README.md for detailed documentation
2. Review application logs in the console
3. Inspect H2 database for data issues
4. Verify configuration in application.properties

## Performance Tips

- Use specific search criteria to reduce result set
- Index columns are optimized for CIF, Account Number, Doc ID, and Reference ID
- Date range searches may be slower on large datasets
- Consider adding more indexes for frequently searched columns

---

**Happy Searching! 🔍**