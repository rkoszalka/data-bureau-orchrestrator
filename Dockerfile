FROM openjdk:11
LABEL source = "data-bureau-orchestrator"
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]