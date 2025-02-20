#
# Run app
#
FROM maven:3 AS build-run

WORKDIR /app

COPY pom.xml .
COPY /src ./src

RUN mvn clean package -D skipTests

ENTRYPOINT ["java", "-jar", "target/cliente-service-0.0.1-SNAPSHOT.jar"]