FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package
FROM openjdk:8-jre-alpine
WORKDIR /zuul
COPY --from=MAVEN_BUILD /build/target/zuul-1.0-SNAPSHOT.jar /zuul/
ENTRYPOINT ["java", "-jar", "zuul-1.0-SNAPSHOT.jar"]