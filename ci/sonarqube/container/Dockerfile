ARG BASE_IMAGE=sonarqube:enterprise

FROM $BASE_IMAGE AS source

RUN cp  "$SONARQUBE_HOME"/lib/sonar-application-"$SONAR_VERSION".jar /tmp/sonar-application.jar

# sonarqube 新版本的没有jar命令，里面的tar不支持append模式, 换镜像
FROM openjdk:11 AS builder
COPY --from=source /tmp/sonar-application.jar /tmp/sonar-application.jar
ADD sonarsource-dsa-public.key /tmp
RUN set -x; ls /tmp
WORKDIR /tmp
RUN chmod 664 sonar-application.jar \
  && jar uvf  sonar-application.jar sonarsource-dsa-public.key

FROM $BASE_IMAGE
COPY --from=builder /tmp/sonar-application.jar  $SONARQUBE_HOME/lib/sonar-application-$SONAR_VERSION.jar

ADD conf conf
ADD lib lib