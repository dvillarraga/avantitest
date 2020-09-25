FROM gradle:6.6.1-jdk8

USER root

COPY ./src /home/gradle/project

WORKDIR /home/gradle/project
