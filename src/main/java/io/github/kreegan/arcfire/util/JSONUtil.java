package io.github.kreegan.arcfire.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Utility for working with JSON data files
 */
public class JSONUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONUtil.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode readFromFile(String fileName) {

        try {
            File file = new File(fileName);
            LOGGER.info("File path: " + file.getAbsolutePath());
            JsonNode jsonNode = objectMapper.readTree(file);
            return jsonNode;
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return null;
    }

    public static String getObjectAsJSONString(Object obj) {

        String retVal = "";

        try {
            retVal = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return retVal;
    }
}
