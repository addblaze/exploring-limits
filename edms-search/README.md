# EDMS Search Application

A Spring Boot application with Thymeleaf UI for searching EDMS (Electronic Document Management System) data across multiple loan journeys.

## Technology Stack

- **JDK**: 1.8
- **Spring Boot**: 1.5.19.RELEASE
- **Database**: H2 (In-Memory)
- **Template Engine**: Thymeleaf
- **Build Tool**: Maven

## Features

- **Multi-Journey Support**: Search across different loan types (Home Loan, Personal Loan, Auto Loan, Credit Card, Business Loan)
- **Dynamic Search**: Search by CIF, Account Number, Document ID, Reference ID, and Date Range
- **Pagination**: Display up to 100 records per page with pagination support
- **Configurable**: Add new journeys and columns via properties file without code changes
- **Responsive UI**: Modern, user-friendly interface with gradient design

## Project Structure

```
edms-search/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/edms/
│   │   │       ├── EdmsSearchApplication.java
│   │   │       ├── config/
│   │   │       │   └── JourneyConfiguration.java
│   │   │       ├── controller/
│   │   │       │   └── EdmsSearchController.java
│   │   │       ├── dto/
│   │   │       │   ├── SearchRequest.java
│   │   │       │   └── SearchResponse.java
│   │   │       ├── repository/
│   │   │       │   └── EdmsRepository.java
│   │   │       └── service/
│   │   │           └── EdmsSearchService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── schema.sql
│   │       ├── data.sql
│   │       └── templates/
│   │           └── index.html
│   └── test/
└── pom.xml
```

## Configuration

### Adding a New Journey

To add a new journey, update `application.properties`:

```properties
# Add journey to available list
journey.available=homeLoan,personalLoan,autoLoan,creditCard,businessLoan,newJourney

# Configure new journey
journey.newJourney.table=NEW_JOURNEY_EDMS
journey.newJourney.columns=id,cif,accountNumber,docId,referenceId,documentType,uploadDate,status
journey.newJourney.searchColumns=cif,accountNumber,docId,referenceId
```

Then create the corresponding table in `schema.sql`:

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

## How to Run

### Prerequisites

- JDK 1.8 installed
- Maven installed

### Steps

1. **Clone or extract the project**

2. **Navigate to project directory**
   ```bash
   cd edms-search
   ```

3. **Build the project**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```
   
   Or run the JAR file:
   ```bash
   java -jar target/edms-search-1.0.0.jar
   ```

5. **Access the application**
   - Open browser and navigate to: `http://localhost:8080`
   - H2 Console (for database inspection): `http://localhost:8080/h2-console`
     - JDBC URL: `jdbc:h2:mem:edmsdb`
     - Username: `sa`
     - Password: (leave empty)

## Usage

1. **Select Journey**: Choose the loan type from the dropdown
2. **Enter Search Criteria**: Provide at least one search parameter:
   - CIF Number
   - Account Number
   - Document ID
   - Reference ID
   - Date Range (From Date and To Date)
3. **Click Search**: View results in a paginated table
4. **Navigate Pages**: Use Previous/Next buttons for pagination

## Sample Data

The application comes pre-loaded with sample data for all journey types:
- 110 Home Loan records
- 10 Personal Loan records
- 10 Auto Loan records
- 10 Credit Card records
- 10 Business Loan records

### Sample Search Queries

- **Search by CIF**: `CIF001`
- **Search by Account Number**: `HL001`
- **Search by Document ID**: `DOC-HL-001`
- **Search by Reference ID**: `REF-HL-001`

## API Endpoints

- `GET /` - Display search form
- `POST /search` - Perform search and display results
- `GET /h2-console` - Access H2 database console

## Database Schema

Each journey table has the following structure:

| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT | Primary Key (Auto-increment) |
| cif | VARCHAR(50) | Customer Information File Number |
| accountNumber | VARCHAR(50) | Account Number |
| docId | VARCHAR(100) | Document ID |
| referenceId | VARCHAR(100) | Reference ID |
| documentType | VARCHAR(100) | Type of Document |
| uploadDate | DATE | Document Upload Date |
| status | VARCHAR(50) | Document Status |

## Customization

### Modify Page Size

Update `application.properties`:
```properties
app.page.size=50
```

### Add/Remove Columns

Update the journey configuration in `application.properties`:
```properties
journey.homeLoan.columns=id,cif,accountNumber,docId,referenceId,documentType,uploadDate,status,newColumn
```

### Modify Search Columns

Update searchable columns in `application.properties`:
```properties
journey.homeLoan.searchColumns=cif,accountNumber,docId,referenceId,newSearchColumn
```

## Troubleshooting

### Port Already in Use
If port 8080 is already in use, change it in `application.properties`:
```properties
server.port=8081
```

### Database Connection Issues
Ensure H2 database configuration is correct in `application.properties`:
```properties
spring.datasource.url=jdbc:h2:mem:edmsdb
spring.datasource.username=sa
spring.datasource.password=
```

### No Records Found
- Verify the journey name is correct
- Check if sample data is loaded (check H2 console)
- Ensure at least one search criteria is provided

## Future Enhancements

- Export search results to Excel/CSV
- Advanced filtering options
- Document preview functionality
- User authentication and authorization
- Audit logging
- Real-time search with auto-complete
- Dashboard with statistics

## License

This project is for demonstration purposes.

## Contact

For questions or support, please contact the development team.