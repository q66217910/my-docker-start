# Jenkins主节点镜像制作

1. 基础镜像选用官方稳定版本镜像jenkins/jenkins:lts-jdk17


## 一. 如何使用

### 1-1.设置配置
配置文件：[master/conf/config.env](master/conf/config.env)


### 1-2.启动master节点
```shell
cd master
docker compose up -d
```

### 1-3. master节点启动完成后
点击【系统管理】->【节点管理】

查看相应的节点获取节点的
JENKINS_AGENT_NAME和JENKINS_SECRET

### 1-4. 启动salve节点
填写节点的JENKINS_AGENT_NAME和JENKINS_SECRET/JENKINS_URL3个值,然后启动
```shell
cd agent
docker compose up -d
```
PS: 若多个子节点,在不同服务器上启动即可，要一个服务器对应一个NODE

## 二.安装插件

### 2-1.安装指令

在很多情况下,制作出来的镜像会运行在没有网络的环境中,所以需要在制作镜像时,提前安装插件
执行指令
```shell
jenkins-plugin-cli --latest true --plugin-file /usr/share/jenkins/ref/plugins.txt
```

### 2-2.plugins.txt如何获取
文档地址： https://www.jenkins.io/doc/book/managing/plugins/

在已有的Jenkins中，通过脚本获取插件列表

```groovy
 Jenkins.instance.pluginManager.plugins.each {
      println("${it.getShortName()}: ${it.getVersion()}")
}
```