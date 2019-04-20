package com.example.project.test12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;
import static org.junit.jupiter.params.provider.EnumSource.Mode.MATCH_ALL;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.example.project.Book;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.project.StringUtils;

public class ParameterizedDemo {
	@ParameterizedTest
	@ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
	void palindromes(String candidate) {
		assertTrue(StringUtils.isPalindrome(candidate));
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void testWithValueSource(int argument) {
		assertTrue(argument > 0 && argument < 4);
	}

	@ParameterizedTest
	@NullSource
	@EmptySource
	@ValueSource(strings = {" ", "   ", "\t", "\n"})
	void nullEmptyAndBlankStrings1(String text) {
		assertTrue(text == null || text.trim().isEmpty());
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {" ", "   ", "\t", "\n"})
	void nullEmptyAndBlankStrings2(String text) {
		assertTrue(text == null || text.trim().isEmpty());
	}

	/**
	 * Enums
	 */

	@ParameterizedTest
	@EnumSource(TimeUnit.class)
	void testWithEnumSource(TimeUnit timeUnit) {
		assertNotNull(timeUnit);
	}

	@ParameterizedTest
	@EnumSource(value = TimeUnit.class, names = {"DAYS", "HOURS"})
	void testWithEnumSourceInclude(TimeUnit timeUnit) {
		assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
	}

	@ParameterizedTest
	@EnumSource(value = TimeUnit.class, mode = EXCLUDE, names = {"DAYS", "HOURS"})
	void testWithEnumSourceExclude(TimeUnit timeUnit) {
		assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
		assertTrue(timeUnit.name().length() > 5);
	}

	@ParameterizedTest
	@EnumSource(value = TimeUnit.class, mode = MATCH_ALL, names = "^(M|N).+SECONDS$")
	void testWithEnumSourceRegex(TimeUnit timeUnit) {
		String name = timeUnit.name();
		assertTrue(name.startsWith("M") || name.startsWith("N"));
		assertTrue(name.endsWith("SECONDS"));
	}

	/**
	 *
	 * Methods
	 *
	 */

	@ParameterizedTest
	@MethodSource("stringProvider")
	void testWithExplicitLocalMethodSource(String argument) {
		assertNotNull(argument);
	}

	static Stream<String> stringProvider() {
		return Stream.of("apple", "banana");
	}

	@ParameterizedTest
	@MethodSource
	void testWithDefaultLocalMethodSource(String argument) {
		assertNotNull(argument);
	}

	static Stream<String> testWithDefaultLocalMethodSource() {
		return Stream.of("apple", "banana");
	}

	@ParameterizedTest
	@MethodSource("range")
	void testWithRangeMethodSource(int argument) {
		assertNotEquals(9, argument);
	}

	static IntStream range() {
		return IntStream.range(0, 20).skip(10);
	}

	// Methods with multiple input parameters
	@ParameterizedTest
	@MethodSource("stringIntAndListProvider")
	void testWithMultiArgMethodSource(String str, int num, List<String> list) {
		assertEquals(5, str.length());
		assertTrue(num >= 1 && num <= 2);
		assertEquals(2, list.size());
	}

	static Stream<Arguments> stringIntAndListProvider() {
		return Stream.of(
				arguments("apple", 1, Arrays.asList("a", "b")),
				arguments("lemon", 2, Arrays.asList("x", "y"))
		);
	}


	/**
	 *
	 * CSV
	 *
	 */

	@ParameterizedTest
	@CsvSource({
			"apple,         1",
			"banana,        2",
			"'lemon, lime', 0xF1"
	})
	void testWithCsvSource(String fruit, int rank) {
		assertNotNull(fruit);
		assertNotEquals(0, rank);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/two-column.csv", numLinesToSkip = 1)
	void testWithCsvFileSource(String country, int reference) {
		assertNotNull(country);
		assertNotEquals(0, reference);
	}

	/**
	 *
	 * ArgumentsProvider
	 *
	 */

	@ParameterizedTest
	@ArgumentsSource(MyArgumentsProvider.class)
	void testWithArgumentsSource(String argument) {
		assertNotNull(argument);
	}

	@ParameterizedTest
	@ArgumentsSource(MyArgumentsProvider.class)
	void testBooks(Book book) {
		assertNotNull(book);
	}

}
