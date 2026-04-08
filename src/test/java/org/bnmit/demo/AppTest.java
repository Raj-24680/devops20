package org.bnmit.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testGreet() {
        assertEquals("Hello, Welcome to CI/CD Pipeline", App.greet());
    }
}
