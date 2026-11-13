pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}



// Загружаем плагины для всего проекта на этапе инициализации
plugins {
    id("org.springframework.boot") version "3.4.2" apply false
    id("io.spring.dependency-management") version "1.1.7" apply false
}

include(":apps:api-gateway")
include(":libs:grpc-contracts")
include(":libs:common-constants")



