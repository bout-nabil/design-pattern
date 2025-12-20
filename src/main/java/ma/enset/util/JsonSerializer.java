package ma.enset.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer<T> {
    public String toJson(T dataObject){
        // Implémentation de la sérialisation en JSON
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}