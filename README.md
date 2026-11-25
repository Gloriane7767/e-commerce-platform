# E-Commerce Platform

A Spring Boot 4 e-commerce application built with Java 25 and Spring Data JPA. The project uses a layered architecture with JPA entities and repositories, and is configured for both local development and production database environments.

## Technology Stack

- Java 25
- Spring Boot 4.0.2
- Spring Web MVC
- Spring Data JPA
- Hibernate
- Bean Validation
- Maven Wrapper
- H2 (development/testing)
- MySQL (development/production)
- Lombok

## Features

- Spring Boot application entry point
- JPA/Hibernate entity and repository support
- Development and production configuration profiles
- MySQL database integration
- In-memory H2 database support
- Maven-based build and test workflow
- Development data initialization support

## Prerequisites

- JDK 25
- Maven 3.9+ (optional because the Maven Wrapper is included)
- MySQL 8+ for the MySQL development/production configurations

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/Gloriane7767/e-commerce-platform.git
cd e-commerce-platform
```

### 2. Select a profile

The application enables the `dev` profile by default in `src/main/resources/application.properties`.

#### Development profile

The development profile is configured to use MySQL at:

```text
jdbc:mysql://localhost:3306/ecommerce_db
```

Create the database before starting the application:

```sql
CREATE DATABASE ecommerce_db;
```

Update the database credentials in `src/main/resources/application-dev.properties` if they differ from your local MySQL setup.

Then start the application:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
mvnw.cmd spring-boot:run
```

The server is configured to run on port `9090` in the development profile:

```text
http://localhost:9090
```

### 3. Run tests

```bash
./mvnw test
```

On Windows:

```powershell
mvnw.cmd test
```

### 4. Build the application

```bash
./mvnw clean package
```

The executable JAR will be created in the `target/` directory:

```bash
java -jar target/e-commerce-platform-0.0.1-SNAPSHOT.jar
```

## Configuration Profiles

| Profile | Purpose | Configuration file |
|---|---|---|
| `dev` | Local development | `application-dev.properties` |
| `prd` | Production-style environment | `application-prd.properties.properties` |

To explicitly select a profile when starting the application:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

Or run the packaged JAR:

```bash
java -jar target/e-commerce-platform-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
```

## Project Structure

```text
.
├── src/
│   ├── main/
│   │   ├── java/com/gloriane/ecommerceplatform/
│   │   │   ├── entity/                         # JPA entities
│   │   │   ├── repository/                     # Spring Data repositories
│   │   │   ├── ECommercePlatformApplication.java
│   │   │   └── TestDataRunner.java
│   │   └── resources/
│   │       ├── application.properties          # Active profile
│   │       ├── application-dev.properties      # Development configuration
│   │       └── application-prd.properties.properties
│   └── test/java/com/gloriane/ecommerceplatform/
├── pom.xml                                      # Maven dependencies and plugins
├── mvnw                                         # Unix Maven Wrapper
└── mvnw.cmd                                     # Windows Maven Wrapper
```

## Database Behavior

The development profile uses Hibernate to create and update the database schema automatically:

```properties
spring.jpa.hibernate.ddl-auto=create
```

> **Warning:** `create` drops and recreates tables when the application starts. Use `update` or `validate` for environments where existing data must be preserved.

## Security Note

Do not commit real database passwords or production secrets to source control. Use environment variables or a secrets manager for credentials in deployed environments.

Example:

```bash
export SPRING_DATASOURCE_USERNAME=your_username
export SPRING_DATASOURCE_PASSWORD=your_password
./mvnw spring-boot:run
```

## Contributing

1. Fork the repository.
2. Create a feature branch:

   ```bash
   git checkout -b feature/your-feature
   ```

3. Commit your changes:

   ```bash
   git commit -m "Add your feature"
   ```

4. Push the branch and open a pull request.

## License

No license has been specified for this repository. All rights are currently reserved by the repository owner unless a license is added.
