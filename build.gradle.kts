import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.6"
	id("org.openapi.generator").version("5.3.0")
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.31"
	kotlin("plugin.spring") version "1.5.31"
	kotlin("plugin.jpa") version "1.5.31"
}

group = "com.hometask"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("javax.validation:validation-api:2.0.1.Final")
	implementation("org.flywaydb:flyway-core")
	api("io.springfox:springfox-swagger2:3.0.0")
	api("io.springfox:springfox-swagger-ui:3.0.0")
	api("org.openapitools:jackson-databind-nullable:0.2.1")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.h2database:h2")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}
val spec = "$rootDir/src/main/resources/openapi/api.yml"
val generatedSourcesDir = "$buildDir/generated/openapi"

openApiGenerate {
	generatorName.set("spring")

	inputSpec.set(spec)
	outputDir.set(generatedSourcesDir)

	apiPackage.set("org.openapi.example.api")
	invokerPackage.set("org.openapi.example.invoker")
	modelPackage.set("org.openapi.example.model")

	configOptions.set(mapOf(
		"dateLibrary" to "java8"
	))
}

sourceSets {
	getByName("main") {
		java {
			srcDir("$generatedSourcesDir/src/main/java")
		}
	}
}

tasks {
	val openApiGenerate by getting

	val compileJava by getting {
		dependsOn(openApiGenerate)
	}
}
tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
