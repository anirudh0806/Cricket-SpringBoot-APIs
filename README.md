# Cricket APIs 

A RESTful application for managing cricket player data using Spring Boot and MongoDB Atlas, deployed on Railway.

## Overview

This project provides a comprehensive API for cricket player management, including operations for creating, reading, updating, and deleting cricketer information. The system is built with Spring Boot and uses MongoDB Atlas as its cloud database.

## Technologies

- Java
- Spring Boot 3.2.3
- Spring Data MongoDB
- MongoDB Atlas
- Maven
- Lombok
- Railway (Deployment Platform)

## Prerequisites

For local development:
- JDK 17+
- Maven 3+
- MongoDB or MongoDB Atlas connection

## Configuration

The application is configured to connect to a MongoDB Atlas database. The database configuration can be found in `application.properties`:

```properties
spring.application.name=cricket
spring.data.mongodb.uri=mongodb+srv://anirudh:anirudh@cricketcluster.v6ev0af.mongodb.net/
spring.data.mongodb.database=cricketdb
```

## Deployment

The application is deployed on Railway and can be accessed at:
```
https://cricket-springboot-apis-production.up.railway.app
```

### Railway Configuration

The deployment is configured using the following railway.json file:

```json
{
  "$schema": "https://railway.com/railway.schema.json",
  "build": {
    "builder": "NIXPACKS"
  },
  "deploy": {
    "runtime": "V2",
    "numReplicas": 1,
    "sleepApplication": false,
    "multiRegionConfig": {
      "europe-west4-drams3a": {
        "numReplicas": 1
      }
    },
    "restartPolicyType": "ON_FAILURE",
    "restartPolicyMaxRetries": 10
  }
}
```

The application is configured to stay active at all times (doesn't sleep) and automatically restarts on failures.

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

2. Build the application:
   ```
   mvn clean install
   ```

3. Run the application locally:
   ```
   mvn spring-boot:run
   ```

4. For local development, the API will be available at `http://localhost:8080/api/cricketers`

## Usage Examples

### Using the deployed API with Postman

1. Open Postman
2. Enter the API URL: `https://cricket-springboot-apis-production.up.railway.app/api/cricketers`
3. Select the appropriate HTTP method (GET, POST, PUT, DELETE)
4. Add headers and body as required
5. Send the request

**Creating a new cricketer:**
```bash
curl -X POST -H "Content-Type: application/json" -d '{
  "name": "Virat Kohli",
  "age": 36,
  "country": "India",
  "role": "Batsman",
}' https://cricket-springboot-apis-production.up.railway.app/api/cricketers
```

## Troubleshooting

If you encounter database connection issues:
1. Verify MongoDB Atlas credentials are correct
2. Check network connectivity to MongoDB Atlas cluster
3. Ensure the correct database name is configured in application.properties
