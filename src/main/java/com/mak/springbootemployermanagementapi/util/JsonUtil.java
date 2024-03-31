package com.mak.springbootemployermanagementapi.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mak.springbootemployermanagementapi.Employer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger LOGGER = Logger.getLogger(JsonUtil.class.getName());


    public static Employer readJsonFromFile(String filePath) {

        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get(filePath)));
            return objectMapper.readValue(json, Employer.class);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading JSON file: " + filePath, e);
        }

        return null;

    }

    public static List<Employer> readJsonArrayFromFile(String filePath) {
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get(filePath)));
            Employer[] employers = objectMapper.readValue(json, Employer[].class);
            return Arrays.asList(employers);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading JSON file: " + filePath, e);
        }
        return null;
    }
}