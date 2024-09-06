package com.lhgomes.dev.multicloud;

import redis.clients.jedis.Jedis;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class RedisService implements NoSqlService {

    private final Jedis jedis;
    private final ObjectMapper objectMapper;

    public RedisService(String host, int port) {
        this.jedis = new Jedis(host, port);
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void savePayload(String key, Map<String, Object> payload) {
        try {
            String json = objectMapper.writeValueAsString(payload);
            jedis.set(key, json);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save payload to Redis", e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> getPayload(String key) {
        try {
            String json = jedis.get(key);
            if (json != null) {
                return objectMapper.readValue(json, Map.class);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get payload from Redis", e);
        }
    }
}