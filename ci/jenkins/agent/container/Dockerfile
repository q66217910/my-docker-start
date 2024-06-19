FROM jenkins/inbound-agent

USER root

##安装oracle-jdk8
RUN  mkdir -p /opt/java/oracle-jdk8 && cd /opt/java/oracle-jdk8 && \
    curl -LfsSo /opt/java/oracle-jdk8/jdk-8u341-linux-x64.tar.gz https://repo.swifer.co:443/artifactory/download/jdk/oracle/jdk-8u341-linux-x64.tar.gz && \
    tar -xvf jdk-8u341-linux-x64.tar.gz --strip-components=1 && rm -rf jdk-8u341-linux-x64.tar.gz

RUN mkdir -p /opt/maven/apache-maven-3.8.4 && cd /opt/maven/apache-maven-3.8.4 && \
        curl -LfsSo /opt/maven/apache-maven-3.8.4/apache-maven-3.8.4-bin.tar.gz https://repo.swifer.co:443/artifactory/one-click-deploy/maven/apache-maven-3.8.4-bin.tar.gz && \
        tar -xvf apache-maven-3.8.4-bin.tar.gz --strip-components=1 && rm -rf apache-maven-3.8.4-bin.tar.gz

USER jenkins