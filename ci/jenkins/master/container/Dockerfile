FROM jenkins/jenkins:lts-jdk17
## 安装插件
COPY --chown=jenkins:jenkins plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --latest true --plugin-file /usr/share/jenkins/ref/plugins.txt

## 设置初始化脚本
COPY --chown=jenkins:jenkins executors.groovy /usr/share/jenkins/ref/init.groovy.d/executors.groovy