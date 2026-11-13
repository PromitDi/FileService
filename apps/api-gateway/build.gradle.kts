plugins {
	// Активируем плагины для этого конкретного приложения
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.dependency.management)
}

dependencies {

	implementation(libs.spring.boot.starter.web)

	implementation(libs.spring.kafka)
	implementation(libs.minio)
	implementation(libs.grpc.protobuf)
	implementation(libs.grpc.stub)
	implementation(libs.grpc.spring.boot.client)
	implementation(libs.protobuf.java)

	testImplementation(libs.spring.boot.starter.test)
	testRuntimeOnly(libs.junit.launcher)
	implementation(project(":libs:grpc-contracts"))
	implementation(project(":libs:common-constants"))
}