# Expeknow Backend
Copyright © 2025 Expeknow

## License

- PostgreSQL Driver
- H2 Database
- JWT (jjwt)
- Jackson Kotlin Module
- Spring Boot Starter Validation
- Spring Boot Starter Security
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
Key dependencies include:

## Dependencies

- Implement proper error handling
- Use data classes for DTOs
- Follow Spring Boot best practices
- Use Kotlin idioms and conventions

### Code Style

5. Create controllers in `controller` package
4. Create DTOs in `dto` package
3. Implement business logic in `service` package
2. Create repository interfaces in `repository` package
1. Create entity classes in `entity` package

### Adding New Features

## Development

- Password: (leave blank)
- Username: `sa`
- JDBC URL: `jdbc:h2:mem:testdb`
- URL: `http://localhost:8080/h2-console`

### H2 Console (Development Only)

- `GET /actuator/health` - Spring Boot actuator health endpoint
- `GET /api/public/health` - Health check endpoint

### Public Endpoints

## API Endpoints

5. Adjust logging levels
4. Disable H2 console
3. Switch to a production database (PostgreSQL)
2. Update allowed CORS origins
1. Change the JWT secret in `application.yml`
⚠️ **Before deploying to production:**

### Important: Security Configuration

- **CORS**: Allowed origins, methods, and headers
- **JWT**: Secret key and expiration time
- **Database**: H2 in-memory database (change for production)
- **Server Port**: Default is 8080

The application can be configured via `src/main/resources/application.yml`:

## Configuration

```
./gradlew test
```bash

### Running Tests

```
./gradlew build
```bash

### Building the Application

The application will start on `http://localhost:8080`

   ```
   ./gradlew bootRun
   ```bash
3. Run the application:
2. Navigate to the project directory
1. Clone the repository

### Running the Application

- Gradle (included via wrapper)
- JDK 17 or higher

### Prerequisites

## Getting Started

```
    └── HealthController.kt        # Health check endpoint
└── controller/                     # REST controllers
│   └── util/                      # Utility classes (JWT, etc.)
│   ├── exception/                 # Custom exceptions and global handler
│   ├── dto/                       # Common DTOs
├── common/                         # Common utilities and shared code
│   └── JacksonConfig.kt           # JSON serialization configuration
│   ├── SecurityConfig.kt          # Spring Security configuration
│   ├── CorsConfig.kt              # CORS configuration
├── config/                         # Configuration classes
├── BackendApplication.kt           # Main application entry point
src/main/kotlin/com/expeknow/backend/
```

## Project Structure

- H2 console for development
- Health check endpoints
- Input validation
- CORS configuration
- Global exception handling
- Spring Security configuration
- JWT-based authentication
- RESTful API architecture

## Features

- **Database**: H2 (Development), PostgreSQL (Production)
- **Java Version**: 17
- **Build Tool**: Gradle
- **Framework**: Spring Boot 3.5.7
- **Language**: Kotlin 1.9.25

## Tech Stack

A Spring Boot backend application built with Kotlin.


