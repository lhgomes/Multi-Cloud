package com.lhgomes.dev.multicloud;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

import java.util.HashMap;
import java.util.Map;

public class DynamoDBService implements NoSqlService {

    private final DynamoDbClient client;
    private final String tableName;

    public DynamoDBService(String tableName) {
        this.client = DynamoDbClient.builder()
                .region(Region.ME_CENTRAL_1)
                .build();
        this.tableName = tableName;
    }

    @Override
    public void savePayload(String key, Map<String, Object> payload) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("id", AttributeValue.builder().s(key).build());

        for (Map.Entry<String, Object> entry : payload.entrySet()) {
            item.put(entry.getKey(), AttributeValue.builder().s(entry.getValue().toString()).build());
        }

        PutItemRequest request = PutItemRequest.builder()
                .tableName(tableName)
                .item(item)
                .build();

        try {
            client.putItem(request);
        } catch (DynamoDbException e) {
            throw new RuntimeException("Failed to save payload to DynamoDB", e);
        }
    }

    @Override
    public Map<String, Object> getPayload(String key) {
        Map<String, AttributeValue> keyToGet = new HashMap<>();
        keyToGet.put("id", AttributeValue.builder().s(key).build());

        GetItemRequest request = GetItemRequest.builder()
                .tableName(tableName)
                .key(keyToGet)
                .build();

        try {
            Map<String, AttributeValue> returnedItem = client.getItem(request).item();
            if (returnedItem != null) {
                Map<String, Object> result = new HashMap<>();
                for (Map.Entry<String, AttributeValue> entry : returnedItem.entrySet()) {
                    result.put(entry.getKey(), entry.getValue().s());
                }
                return result;
            } else {
                return null; // Item not found
            }
        } catch (DynamoDbException e) {
            throw new RuntimeException("Failed to get payload from DynamoDB", e);
        }
    }
}