package com.flexit;

import com.flexit.backoffice.controller.EmployeeController;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@SpringBootTest
class BackofficeApplicationTests {

    @Autowired
    private EmployeeController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }
}
