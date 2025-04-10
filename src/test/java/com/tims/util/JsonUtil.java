package com.tims.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tests.vendorportal.model.VendorPortalTestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtil {
    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();

//    public static VendorPortalTestData getTestData(String path) {
//        try (InputStream stream = ResourceLoader.getResource(path)) {
//            return mapper.readValue(stream, VendorPortalTestData.class);
//
//        } catch (Exception e) {
//            log.error("unable to read test data {}", path, e);
//        }
//        return null;
//    }

    public static <T> T getTestData(String path, Class<T> type) {

        try (InputStream stream = ResourceLoader.getResource(path)) {
            return mapper.readValue(stream, type);

        } catch (Exception e) {
            log.error("unable to read test data {}", path, e);
        }
        return null;
    }
//    public static <T> T getTestData(String path, Class<T> type) {
//        try (InputStream stream = JsonUtil.class.getClassLoader().getResourceAsStream(path)) {
//            if (stream == null) {
//                throw new IOException("Resource not found: " + path);
//            }
//            return mapper.readValue(stream, type);
//        } catch (Exception e) {
//            log.error("Unable to read test data: {}", path, e);
//        }
//        return null;
//    }

}
