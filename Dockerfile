FROM gradle:7.2.0-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test


FROM openjdk:17.0.1-jdk-slim
COPY --from=build /home/gradle/src/build/libs/*.jar internship-project.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "internship-project.jar"]
