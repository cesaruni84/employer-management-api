package com.mak.springbootemployermanagementapi;

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
        Employer employer = new Employer();
        when(employerService.create(any(Employer.class))).thenReturn(employer);

        Employer result = employerController.create(employer);
        assertEquals(employer, result);
    }

    @Test
    public void testUpdate() {
        Employer employer = new Employer();
        when(employerService.update(eq(1), any(Employer.class))).thenReturn(employer);

        Employer result = employerController.update(1, employer);
        assertEquals(employer, result);
    }

    @Test
    public void testDelete() {
        employerController.delete(1);
    }

    @Test
    public void testGet() {
        Employer employer = new Employer();
        when(employerService.get(1)).thenReturn(employer);

        Employer result = employerController.get(1);
        assertEquals(employer, result);
    }

    @Test
    public void testGetAll() {
        List<Employer> employers = Arrays.asList(new Employer(), new Employer());
        when(employerService.get()).thenReturn(employers);

        List<Employer> result = employerController.get();
        assertEquals(employers, result);
    }
}