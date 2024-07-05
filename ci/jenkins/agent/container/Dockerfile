FROM jenkins/inbound-agent

USER root

##安装oracle-jdk8
RUN  mkdir -p /opt/java/oracle-jdk8 && cd /opt/java/oracle-jdk8 && \
    curl -LfsSo /opt/java/oracle-jdk8/jdk-8u341-linux-x64.tar.gz https://repo.swifer.co:443/artifactory/download/jdk/oracle/jdk-8u341-linux-x64.tar.gz && \
    tar -xvf jdk-8u341-linux-x64.tar.gz --strip-components=1 && rm -rf jdk-8u341-linux-x64.tar.gz

##安装open-jdk11
RUN  mkdir -p /opt/java/openjdk11 && cd /opt/java/openjdk11 && \
    curl -LfsSo /opt/java/openjdk11/OpenJDK11U-jdk_x64_linux_hotspot_11.0.16_8.tar.gz https://repo.swifer.co:443/artifactory/download/jdk/Temurin/11/jdk-11.0.16/OpenJDK11U-jdk_x64_linux_hotspot_11.0.16_8.tar.gz && \
    tar -xvf OpenJDK11U-jdk_x64_linux_hotspot_11.0.16_8.tar.gz --strip-components=1 && rm -rf OpenJDK11U-jdk_x64_linux_hotspot_11.0.16_8.tar.gz

RUN mkdir -p /opt/maven/apache-maven-3.8.4 && cd /opt/maven/apache-maven-3.8.4 && \
        curl -LfsSo /opt/maven/apache-maven-3.8.4/apache-maven-3.8.4-bin.tar.gz https://repo.swifer.co:443/artifactory/one-click-deploy/maven/apache-maven-3.8.4-bin.tar.gz && \
        tar -xvf apache-maven-3.8.4-bin.tar.gz --strip-components=1 && rm -rf apache-maven-3.8.4-bin.tar.gz

RUN mkdir -p /home/jenkins/workspace && chown -R jenkins:jenkins /home/jenkins/workspace

USER jenkins

ADD conf/settings.xml /home/jenkins/.m2/settings.xml