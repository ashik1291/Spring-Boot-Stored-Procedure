# Spring Boot Stored Procedure Project

A simple Spring Boot application that demonstrates how to call a **MySQL stored procedure** from a Spring Data JPA repository.

## Project Overview

This project exposes a REST API to fetch cars from the database using the stored procedure `FIND_CARS_AFTER_YEAR`.

### What it does

- Creates a Spring Boot application with **Spring Web** and **Spring Data JPA**
- Connects to a **MySQL** database
- Calls a native SQL stored procedure via `@Query`
- Returns a list of `Car` objects filtered by year

## Technology Stack

- Java 17
- Spring Boot 2.7.5
- Spring Web
- Spring Data JPA
- MySQL Connector/J
- Maven

## Project Structure

- `src/main/java/com/example/springbootandstoredprocedure`
  - `SpringBootAndStoredProcedureApplication.java` – application entry point
  - `controller/CarController.java` – REST controller
  - `service/CarService.java` – business logic layer
  - `repository/CarRepository.java` – repository with stored procedure call
  - `entity/Car.java` – entity mapped to the `car` table
- `src/main/resources/application.properties` – database and server configuration
- `src/test/java/.../SpringBootAndStoredProcedureApplicationTests.java` – basic Spring context test

## API Endpoint

### GET /carsafteryear/{year}

Returns all cars whose model year is greater than the provided year.

Example:

```bash
curl http://localhost:6969/carsafteryear/2018
```

## Stored Procedure Integration

The repository contains this native query:

```java
@Query(value = "CALL FIND_CARS_AFTER_YEAR(:year_in);", nativeQuery = true)
List<Car> findCarsAfterYear(@Param("year_in") int year);
```

This means the application depends on a MySQL stored procedure named `FIND_CARS_AFTER_YEAR` that accepts an input parameter `year_in`.

## Configuration

The current configuration is in `src/main/resources/application.properties`:

```properties
spring.jpa.show-sql=true
spring.jpa.defer-datasource-initialization=true

spring.datasource.url=jdbc:mysql://localhost:3306/practice_stored_procedure
spring.datasource.username=root
spring.datasource.password=password

server.port=6969
```

### Required setup

1. Install and start **MySQL**.
2. Create a database named `practice_stored_procedure`.
3. Create the `FIND_CARS_AFTER_YEAR` stored procedure.
4. Make sure the `car` table and its columns align with the `Car` entity.

## Running the Project

From the project root:

```bash
cd Spring-Boot-and-Stored-Procedure
./mvnw spring-boot:run
```

The application will start on port `6969`.

## Example Response

```json
[
  {
    "id": 1,
    "model": "Tesla Model 3",
    "year": 2020
  },
  {
    "id": 2,
    "model": "BMW X5",
    "year": 2022
  }
]
```

## Testing

A basic application context test is included:

```bash
./mvnw test
```

## Notes

- The current code is focused on **demonstrating stored procedure usage**.
- The database schema and stored procedure are not included in the repository, so you need to create them in MySQL before running the app.
- The API currently exposes only one endpoint.

## Future Improvements

- Add SQL scripts for schema and stored procedure creation
- Add validation and error handling
- Add more CRUD endpoints
- Add integration tests for the API
