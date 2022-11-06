FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
VOLUME /tmp
EXPOSE 8083
ARG DEPENDENCY=target
ADD ${DEPENDENCY}/*.jar appres.jar
ENTRYPOINT ["java","-jar","/appres.jar"]
