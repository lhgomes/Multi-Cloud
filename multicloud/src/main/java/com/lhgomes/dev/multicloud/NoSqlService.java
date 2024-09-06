package com.lhgomes.dev.multicloud;
import java.util.Map;

public interface NoSqlService {
    void savePayload(String key, Map<String, Object> payload);
    Map<String, Object> getPayload(String key);
}