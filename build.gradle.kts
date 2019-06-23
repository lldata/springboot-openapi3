import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.1.6.RELEASE"
	id("io.spring.dependency-management") version "1.0.7.RELEASE"
	kotlin("jvm") version "1.3.40"
	kotlin("plugin.spring") version "1.3.40"
}

group = "dk.lldata"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.apache.cxf:cxf-spring-boot-starter-jaxrs:3.3.2")
	implementation("com.fasterxml.jackson.jaxrs:jackson-jaxrs-json-provider:2.9.9")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.apache.cxf:cxf-rt-rs-service-description-openapi-v3:3.3.2")
	implementation("javax.xml.ws:jaxws-api:2.3.1")
	implementation("org.webjars:swagger-ui:3.20.9")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
