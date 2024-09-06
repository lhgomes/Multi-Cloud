// Filename: src/main/java/com/lhgomes/dev/multicloud/MulticloudApplication.java
package com.lhgomes.dev.multicloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MulticloudApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MulticloudApplication.class);
        ConfigurableApplicationContext context = app.run(args);

        // Create the datastore component
        NoSqlService noSqlService = context.getBean(NoSqlService.class);

        // Saving a payload
        Map<String, Object> payload = new HashMap<>();
        payload.put("name", "John Doe");
        payload.put("email", "john.doe@example.com");

        noSqlService.savePayload("user1", payload);

        // Retrieving the payload
        Map<String, Object> retrievedPayload = noSqlService.getPayload("user1");
        System.out.println(retrievedPayload.get("name"));

    }
}