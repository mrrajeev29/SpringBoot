#
# Build stage
#
#FROM maven:3.9.9-eclipse-temurin-21 AS build
#WORKDIR /app
#COPY . .

#RUN chmod +x mvnw
#RUN mvn clean package -DskipTests

#
# Package stage
#
#FROM eclipse-temurin:21-jre
#WORKDIR /app
#COPY --from=build /app/target/project-0.0.1-SNAPSHOT.jar app.jar

#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]
#
# Build stage
#
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .

# Use system Maven (mvn), no need for mvnw
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/project-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
