package com.lhgomes.dev.multicloud;

import com.azure.cosmos.*;
import com.azure.cosmos.models.*;
import java.util.Map;

public class CosmosDBService implements NoSqlService {

    private final CosmosClient client;
    private final CosmosContainer container;

    public CosmosDBService(String endpoint, String key, String databaseName, String containerName) {
        this.client = new CosmosClientBuilder()
                .endpoint(endpoint)
                .key(key)
                .consistencyLevel(ConsistencyLevel.EVENTUAL)
                .buildClient();
        CosmosDatabase database = client.getDatabase(databaseName);
        this.container = database.getContainer(containerName);
    }

    @Override
    public void savePayload(String key, Map<String, Object> payload) {
        payload.put("id", key); // CosmosDB requires an 'id' field
        container.createItem(payload);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> getPayload(String key) {
        try {
            CosmosItemResponse<Map> response = container.readItem(key, new PartitionKey(key), Map.class);
            return response.getItem();
        } catch (CosmosException e) {
            if (e.getStatusCode() == 404) {
                return null; // Item not found
            }
            throw e;
        }
    }
}