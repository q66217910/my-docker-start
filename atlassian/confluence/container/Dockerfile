FROM docker.repo.swifer.co/atlassian/confluence-server:8.8.0

RUN curl -LfsSo /var/atlassian/atlassian-agent.jar https://repo.swifer.co:443/artifactory/download/confluence/atlassian-agent.jar

RUN  curl -LfsSo ${CONFLUENCE_INSTALL_DIR}/lib/mysql-connector-java-8.0.22.jar https://repo.swifer.co:443/artifactory/public/mysql/mysql-connector-java/8.0.22/mysql-connector-java-8.0.22.jar

COPY conf/server.xml.j2 /opt/atlassian/etc/server.xml.j2

#https://confluence.atlassian.com/doc/setting-up-a-mail-session-for-the-confluence-distribution-6328.html
RUN mv ${CONFLUENCE_INSTALL_DIR}/confluence/WEB-INF/lib/com.sun.mail_jakarta.mail-1.6.7.jar ${CONFLUENCE_INSTALL_DIR}/lib/mail-1.6.7.jar &&   \
    mv ${CONFLUENCE_INSTALL_DIR}/confluence/WEB-INF/lib/com.sun.activation_jakarta.activation-1.2.2.jar ${CONFLUENCE_INSTALL_DIR}/lib/jakarta.activation-1.2.2.jar

ENV JAVA_OPTS="-javaagent:/var/atlassian/atlassian-agent.jar -Dconfluence.upgradell.recovery.file.enabled=false"