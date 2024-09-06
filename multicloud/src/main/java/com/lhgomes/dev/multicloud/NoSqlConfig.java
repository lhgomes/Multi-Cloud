// Filename: src/main/java/com/lhgomes/dev/multicloud/NoSQLConfig.java
package com.lhgomes.dev.multicloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NoSqlConfig {

    private final NoSqlConfigProperties properties;

    public NoSqlConfig(NoSqlConfigProperties properties) {
        this.properties = properties;
    }
 
    @Bean
    public NoSqlService noSQLOperations() {
        switch (properties.getType().toLowerCase()) {
            case "dynamodb":
                return new DynamoDBService(properties.getTableName());
            case "cosmosdb":
                return new CosmosDBService(properties.getEndpoint(), properties.getKey(),
                        properties.getDatabaseName(), properties.getContainerName());
            case "redis":
                return new RedisService(properties.getHost(), properties.getPort());
            default:
                throw new IllegalArgumentException("Unsupported NoSQL type: " + properties.getType());
        }
    }
}