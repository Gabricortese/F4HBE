FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
VOLUME /tmp
EXPOSE 8095
ARG DEPENDENCY=target
ADD ${DEPENDENCY}/*.jar appan.jar
ENTRYPOINT ["java","-jar","/appan.jar"]
