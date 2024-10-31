package com.FoolishFridge.FoolishFridge.serviceTests;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.mongodb.core.MongoOperations;

import com.FoolishFridge.FoolishFridge.models.FoolishFridge;
import com.FoolishFridge.FoolishFridge.services.FoolishFridgeService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FoolishFridgeServiceTest {

    @Mock
    private MongoOperations mongoOperations;

    @InjectMocks
    private FoolishFridgeService foolishFridgeService;

    @Test
    public void givenDatabaseIsDownWhenTryingToGetFoolishFridgeThenReturnException() {
        when(mongoOperations.findAll(FoolishFridge.class))
                .thenThrow(new DataAccessResourceFailureException("Database is down"));

        assertThrows(DataAccessResourceFailureException.class, () -> {
            foolishFridgeService.getFoolishFridge();
        });
    }
}
