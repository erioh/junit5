package com.example.project.test06;

import static org.junit.jupiter.api.condition.JRE.JAVA_10;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;
import static org.junit.jupiter.api.condition.JRE.JAVA_9;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;

class JavaRuntimeEnvironmentConditions {
	@Test
	@EnabledOnJre(JAVA_8)
	void onlyOnJava8() {
		// ...
	}

	@Test
	@EnabledOnJre({ JAVA_9, JAVA_10 })
	void onJava9Or10() {
		// ...
	}

	@Test
	@DisabledOnJre(JAVA_9)
	void notOnJava9() {
		// ...
	}
}
