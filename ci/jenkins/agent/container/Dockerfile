FROM jenkins/inbound-agent

USER root

##安装oracle-jdk8
RUN  mkdir -p /opt/java/oracle-jdk8 && cd /opt/java/oracle-jdk8 && \
    curl -LfsSo /opt/java/oracle-jdk8/jdk-8u341-linux-x64.tar.gz https://repo.swifer.co:443/artifactory/download/jdk/oracle/jdk-8u341-linux-x64.tar.gz && \
    tar -xvf jdk-8u341-linux-x64.tar.gz --strip-components=1 && rm -rf jdk-8u341-linux-x64.tar.gz

USER jenkins