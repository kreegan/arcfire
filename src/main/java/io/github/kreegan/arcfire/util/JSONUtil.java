package io.github.kreegan.arcfire.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.kreegan.arcfire.generator.RandomGenerator;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;

/**
 * Utility for working with JSON data files
 */
public class JSONUtil {

    private static final Logger LOGGER = Logger.getLogger(JSONUtil.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode readFromFile(String fileName) {

        try {
            JsonNode jsonNode = objectMapper.readTree(fileName);
            return jsonNode;
        } catch (IOException e) {
            LOGGER.error(e);
        }

        return null;
    }

    public static String getObjectAsJSONString(Object obj) {

        String retVal = "";

        try {
            retVal = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error(e);
        }

        return retVal;
    }
}
