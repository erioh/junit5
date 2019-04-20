package com.example.project.test01;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommonAnnotations {
	@BeforeAll
	static void initAll() {
	}

	@BeforeEach
	void init() {
	}

	@Test
	void succeedingTest() {
	}

	@Test
	@DisplayName("Look at my name, my name is amazing!")
	void failingTest() {
		fail("a failing test");
	}

	@Test
	@Disabled("for demonstration purposes")

	void skippedTest() {
		// not executed
	}

	@Test
	@DisplayName("╯°□°）╯")
	void abortedTest() {
		assumeTrue("abc".contains("Z"));
		fail("test should have been aborted");
	}

	@FastTest
	@DisplayName("😱")
	void fastTest() {

	}

	@AfterEach
	void tearDown() {
	}

	@AfterAll
	static void tearDownAll() {
	}

}
