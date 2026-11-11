plugins {
	java
	id("org.springframework.boot") version "3.4.2" apply false
	id("io.spring.dependency-management") version "1.1.7" apply false
}

subprojects {
	group = "com.secure"
	version = "0.0.1-SNAPSHOT"

	// Применяем стандартный Java-плагин ко всем подмодулям
	apply(plugin = "java")

	extensions.configure(org.gradle.api.plugins.JavaPluginExtension::class.java) {
		toolchain {
			languageVersion.set(JavaLanguageVersion.of(21))
		}
	}

	repositories {
		mavenCentral()
	}
}
