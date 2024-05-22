FROM eclipse-temurin:17-alpine as builder
WORKDIR application

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN sed -i 's/\r$//' mvnw
RUN /bin/sh mvnw package -DskipTests

RUN java -Djarmode=layertools -jar target/petlife-api.jar extract

FROM eclipse-temurin:17-jre-alpine
WORKDIR application

EXPOSE 8080

COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
