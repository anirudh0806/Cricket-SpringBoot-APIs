# Cricket Management System

A RESTful application for managing cricket player data using Spring Boot and MongoDB.

## Overview

This project provides a comprehensive API for cricket player management, including operations for creating, reading, updating, and deleting cricketer information. The system is built with Spring Boot and uses MongoDB as its database.

## Technologies

- Java
- Spring Boot 3.2.3
- Spring Data MongoDB
- MongoDB
- Maven
- Lombok

## Prerequisites

- JDK 17+
- Maven 3+
- MongoDB running locally on port 27017

## Configuration

The application is configured to connect to a MongoDB database. The database configuration can be found in `application.properties`:

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=cricketdb
```

## API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/cricketers | Get all cricketers |
| GET | /api/cricketers/{id} | Get cricketer by ID |
| POST | /api/cricketers | Create a new cricketer |
| PUT | /api/cricketers/{id} | Update a cricketer |
| DELETE | /api/cricketers/{id} | Delete a cricketer |

## Setup Instructions

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/cricket-management.git
   cd cricket-management
   ```

2. Ensure MongoDB is running:
   ```
   mongod --port 27017
   ```

3. Build the application:
   ```
   mvn clean install
   ```

4. Run the application:
   ```
   mvn spring-boot:run
   ```

5. The API will be available at `http://localhost:8080/api/cricketers`

## Usage Example

**Creating a new cricketer:**
```bash
curl -X POST -H "Content-Type: application/json" -d '{
  "name": "Virat Kohli",
  "country": "India",
  "role": "Batsman",
  "battingAverage": 53.5,
  "wicketsTaken": 0
}' http://localhost:8080/api/cricketers
```

## Troubleshooting

If you encounter database connection issues:
1. Verify MongoDB is running on the correct port
2. Check that the database name in application.properties matches your target database
3. Ensure there are no conflicting MongoDB configurations in your application classes
