FROM openjdk:8 AS BUILD_IMAGE
ENV APP_HOME=/opt/playframework-hello-world/
WORKDIR $APP_HOME
ADD . $APP_HOME
RUN  ./sbt clean stage

FROM openjdk:8-jre
ENV APP_HOME=/opt/playframework-hello-world/
WORKDIR $APP_HOME
COPY --from=BUILD_IMAGE $APP_HOME/target/universal/stage/ .
EXPOSE 9000
ENTRYPOINT ["bash", "bin/playframework-hello-world"]
CMD ["-h"]