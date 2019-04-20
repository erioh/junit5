package com.example.project.test12;

import java.util.stream.Stream;

class StringsProviders {

    static Stream<String> tinyStrings() {
        return Stream.of(".", "oo", "OOO");
    }
}