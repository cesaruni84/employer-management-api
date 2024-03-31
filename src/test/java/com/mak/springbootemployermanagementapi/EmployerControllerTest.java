package com.mak.springbootemployermanagementapi;

import com.mak.springbootemployermanagementapi.util.JsonUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EmployerControllerTest {

    @InjectMocks
    private EmployerController employerController;

    @Mock
    private EmployerService employerService;

    private Employer employer;

    @BeforeEach
    public void setup() {
        employer = new Employer();
    }

    @Test
    public void testCreate() {
        employer = JsonUtil.readJsonFromFile("src/test/resources/newEmployer.json");
        when(employerService.create(any(Employer.class))).thenReturn(employer);
        Employer result = employerController.create(employer);
        assertEquals(employer, result);
    }

    @Test
    public void testUpdate() {
        employer = JsonUtil.readJsonFromFile("src/test/resources/updateEmployer.json");
        when(employerService.update(eq(1), any(Employer.class))).thenReturn(employer);
        Employer result = employerController.update(1, employer);
        assertEquals(employer, result);
    }

    @Test
    public void testDelete() {
        employerController.delete(1);
        verify(employerService).delete(1);
    }

    @Test
    public void testGet() {
        employer = JsonUtil.readJsonFromFile("src/test/resources/employer.json");
        when(employerService.get(1)).thenReturn(employer);
        Employer result = employerController.get(1);
        assertEquals(employer, result);
        verify(employerService).get(1);
    }

    @Test
    public void testGetAll() {
        List<Employer> employers = JsonUtil.readJsonArrayFromFile("src/test/resources/allEmployers.json");
        when(employerService.get()).thenReturn(employers);
        List<Employer> result = employerController.get();
        assertEquals(employers, result);
        verify(employerService).get();
    }
}