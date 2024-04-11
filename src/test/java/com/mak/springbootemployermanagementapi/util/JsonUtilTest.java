package com.mak.springbootemployermanagementapi.util;

import com.mak.springbootemployermanagementapi.Employer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JsonUtilTest {

    @Test
    void readJsonFromFile() {
        String filePath = "src/test/resources/employer.json";
        Employer employer = JsonUtil.readJsonFromFile(filePath);

        assertNotNull(employer, "The returned employer should not be null");
        assertEquals(4, employer.getId(), "The employer's id should be 4");
    }

    @Test
    void readJsonArrayFromFile() {
        String filePath = "src/test/resources/allEmployers.json";
        List<Employer> employers = JsonUtil.readJsonArrayFromFile(filePath);

        assertNotNull(employers, "The returned list of employers should not be null");
        assertEquals(7, employers.size(), "The size of the returned list should be 7");
    }

    @Test
    void readJsonFromFileThrowsException() {
        String filePath = "src/test/resources/nonexistent.json";
        Employer employer = JsonUtil.readJsonFromFile(filePath);
        assertNull(employer, "The returned employer should be null");

//        try (MockedStatic<Files> mockedFiles = Mockito.mockStatic(Files.class)) {
//            mockedFiles.when(() -> Files.readAllBytes(Paths.get(filePath))).thenThrow(IOException.class);
//
//            assertThrows(RuntimeException.class, () -> JsonUtil.readJsonFromFile(filePath));
//        }
    }

    @Test
    void readJsonArrayFromFileThrowsException() {
        String filePath = "src/test/resources/nonexistent.json";
        List<Employer> employers = JsonUtil.readJsonArrayFromFile(filePath);
        assertNull(employers, "The returned list of employers should be null");
    }
}