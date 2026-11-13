plugins {
    `java-library`
    alias(libs.plugins.protobuf)
}

group = "com.secure"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    api(libs.grpc.stub)
    api(libs.grpc.protobuf)
    api(libs.protobuf.java)
    compileOnly(libs.tomcat.annotations.api)
}

val protobufVersion = libs.versions.protobuf.get()
val grpcVersion = libs.versions.grpc.asProvider().get()

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobufVersion"
    }
    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
    }
    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                create("grpc")
            }
        }
    }
}

