FROM docker.pictet.io/run/adopt-openjdk11:jdk-11.0.6_10
ARG JAR_FILE
COPY --chown=java:users target/${JAR_FILE} /app/APP.jar
ENTRYPOINT exec java -jar $JAVA_OPTIONS /app/APP.jar