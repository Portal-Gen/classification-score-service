
---

# Classification Score Service

## Overview
The Classification Score Service is a robust backend system designed to manage and classify places based on various attributes and scores. It utilizes MongoDB for data storage and offers a RESTful API interface for interacting with the data. This service is particularly useful for applications related to tourism, city planning, or any domain where place data and their classifications are essential.

## Features
- **Add Place Scores**: Allows users to add new place scores with detailed classification data.
- **Retrieve Place Scores**: Users can fetch place scores by their unique identifier to view detailed classification and attribute data.
- **Dockerized Environment**: The service is containerized with Docker, simplifying deployment and environment setup.

## Functions
1. **POST `/placeScores`**: Submit a new place score entry.
2. **GET `/placeScores/{id}`**: Retrieve a place score entry by its unique ID.

## How to Use

### Prerequisites
Ensure you have Docker and Docker Compose installed on your system. These are essential for running the services in a containerized environment.

### Setting Up the Environment
1. **Clone the Repository**: Start by cloning the source code to your local machine.
   ```bash
   git clone <repository-url>
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd path/to/project
   ```

### Using Docker Compose

The service uses Docker Compose to orchestrate multiple containers including the main application and MongoDB.

#### Structure of `docker-compose.yml`
Here's an outline of the Docker Compose setup:
```yaml
version: '3.8'
services:
  mongo:
    image: mongo
    restart: always
    environment:
      MONGO_INITDB_ROOT_USERNAME: mongodb
      MONGO_INITDB_ROOT_PASSWORD: mongodb
    volumes:
      - ./data:/data/db

  mongo-express:
    image: mongo-express
    restart: always
    ports:
      - 8081:8081
    environment:
      ME_CONFIG_MONGODB_ADMINUSERNAME: mongodb
      ME_CONFIG_MONGODB_ADMINPASSWORD: mongodb
      ME_CONFIG_MONGODB_URL: mongodb://mongodb:mongodb@mongo:27017
      ME_CONFIG_BASICAUTH: false

  classification-score-service:
    build: .
    ports:
      - 8080:8080
    depends_on:
      - mongo
    environment:
      DB_URI: mongodb://mongodb:mongodb@mongo:27017/classification_score_db
```

#### Running Docker Compose
To start the services, use the following command in the terminal:
```bash
docker-compose up --build
```
This command builds the images if necessary and starts the containers.

### Accessing the Service
- **Access API**: The service is available at `http://localhost:8080/` where you can use the defined endpoints.
- **Mongo Express**: You can manage your MongoDB database via Mongo Express at `http://localhost:8081/`.

### Interacting with the API
You can use tools like Postman or cURL to interact with the API. Here are examples for each endpoint:

#### Add Place Scores
```bash
curl -X POST http://localhost:8080/placeScores -H 'Content-Type: application/json' -d '{
  "worldCityId": 1704933464,
  "placeId": "unique_place_id_123",
  "classificationScores": { "BEACH": 0.95 },
  "attributes": {
    "hasParking": true,
    "isKidFriendly": true
  },
  "location": {
    "latitude": 11.9304,
    "longitude": 108.4583,
    "address": "Valley of Love, Đà Lạt, Vietnam"
  }
}'
```

#### Get Place Scores
```bash
curl -X GET http://localhost:8080/placeScores/{id}
```

### Stopping the Services
To stop the services, use the following command:
```bash
docker-compose down
```

### Documentation
For detailed information on the API endpoints and their usage, refer to the API documentation available at `http://localhost:8080/swagger-ui.html`.

---
