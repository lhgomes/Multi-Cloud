# Multicloud Spring Boot Project

This is a demo project for a Spring Boot application that integrates with multiple cloud services, including AWS DynamoDB, Azure Cosmos DB, and Redis. The project is set up using Maven and includes a Maven Wrapper for ease of use.

## Project Structure

- **`mvnw` and `mvnw.cmd`**: These are the Maven Wrapper scripts for Unix and Windows systems, respectively. They allow you to run Maven commands without having Maven installed locally.
- **`pom.xml`**: This is the Maven Project Object Model file, which contains information about the project and configuration details used by Maven to build the project.
- **`src/main/resources/application.properties`**: This file contains configuration properties for the Spring Boot application.
- **`src/main/resources/META-INF/additional-spring-configuration-metadata.json`**: This file is used for additional Spring configuration metadata.

## Key Components

### Main Application

- **`MulticloudApplication.java`**: The entry point of the Spring Boot application. It initializes the application context and demonstrates saving and retrieving data using the configured NoSQL service.

### NoSQL Services

- **`DynamoDBService.java`**: Implements the `NoSqlService` interface for AWS DynamoDB operations.
- **`CosmosDBService.java`**: Implements the `NoSqlService` interface for Azure CosmosDB operations.
- **`RedisService.java`**: Implements the `NoSqlService` interface for Redis operations.

### Configuration

- **`NoSQLConfig.java`**: Configures the appropriate NoSQL service based on the properties defined in `application.properties`.
- **`NoSQLConfigProperties.java`**: Maps the NoSQL configuration properties to Java objects.

### Properties

The application can be configured using the `application.properties` file located in `src/main/resources`. Here are some of the key properties:
``` 
nosql.type=dynamodb 
nosql.table=YourTableName 
nosql.endpoint=YourEndpoint 
nosql.key=YourKey 
nosql.host=YourHost 
nosql.port=YourPort
nosql.database=YourDatabaseName 
nosql.container=YourContainerName
```

Replace the placeholders with your actual configuration values.

### Example for DynamoDB:
```
nosql.type=dynamodb
nosql.tableName=YourTableName
```

## Prerequisites

- Java 22
- Maven (or use the Maven Wrapper)

## Getting Started

### Build the Project

To build the project, you can use the Maven Wrapper:
```
bash 
./mvnw clean install
```

Or, if you are on Windows:
```
cmd 
mvnw.cmd clean install
```

### Run the Application

To run the application, use the following command:
```
bash 
./mvnw spring-boot:run
```

Or, on Windows:
```
cmd 
mvnw.cmd spring-boot:run
```

## Dependencies

The project includes the following dependencies:

- **Spring Boot Starter Actuator**: For monitoring and managing the application.
- **Spring Boot Starter**: Core starter, including auto-configuration support, logging, and YAML.
- **Spring Boot Starter Test**: For testing Spring Boot applications.
- **AWS SDK for DynamoDB**: To interact with AWS DynamoDB.
- **Azure Cosmos DB SDK**: To interact with Azure Cosmos DB.
- **Jedis**: A client library for Redis.

## License

This project is licensed under the Apache License, Version 2.0. See the `LICENSE` file for details.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.