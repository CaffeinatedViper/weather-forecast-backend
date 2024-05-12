
FROM openjdk:17-slim


WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

COPY src src

RUN chmod +x ./gradlew


RUN ./gradlew build --no-daemon


RUN ls -l ./build/libs/


EXPOSE 8080

CMD ["sh", "-c", "java -jar $(find ./build/libs -name '*.jar')"]
