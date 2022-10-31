FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
VOLUME /tmp
EXPOSE 8082
ARG DEPENDENCY=target
ADD ${DEPENDENCY}/*.jar appbox.jar
ENTRYPOINT ["java","-jar","/appbox.jar"]
