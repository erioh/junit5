package com.example.project.test14;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

@Execution(CONCURRENT)
public class ConcurrentExecutionDemo {
	@Test
	void test1() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Test
	void test2() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Test
	void test3() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Test
	void test4() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Test
	void test5() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Test
	void test6() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Test
	void test7() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Test
	void test8() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Test
	void test9() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Test
	void test10() throws InterruptedException {
		Thread.sleep(1000);
	}
}
