package com.example.project.test03;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import com.example.project.Calculator;

class AssertJAssertionsDemo {

    private final Calculator calculator = new Calculator();

    @Test
    void assert_true() {
        assertThat(calculator.multiply(4, 2)).isEqualTo(8);
    }

    @Test
    void exception_is_thrown() {
        assertThatThrownBy(() -> calculator.divide(4,0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero");
    }

}