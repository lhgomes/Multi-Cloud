// Filename: src/main/java/com/lhgomes/dev/multicloud/NoSQLConfigProperties.java
package com.lhgomes.dev.multicloud;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "nosql")
public class NoSqlConfigProperties {
    private String type;
    private String tableName;
    private String endpoint;
    private String key;
    private String databaseName;
    private String containerName;
    private String host;
    private int port;

    // Getters and setters
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public String getEndpoint() {
        return endpoint;
    }
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getDatabaseName() {
        return databaseName;
    }
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    public String getContainerName() {
        return containerName;
    }
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
}