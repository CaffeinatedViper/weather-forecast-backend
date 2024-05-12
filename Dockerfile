
FROM openjdk:17-slim
ENV PORT=8080
WORKDIR /app
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew build
EXPOSE 8080
CMD ["java", "-jar", "$(ls ./build/libs/*.jar)"]

