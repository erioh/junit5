package com.example.project.test10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestInterfaceDemo implements TestLifecycleLogger,
        TimeExecutionLogger {

    @Test
    void isEqualValue() {
        assertEquals(1, "a".length(), "is always equal");
    }

}