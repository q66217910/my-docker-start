# Jenkins主节点镜像制作

1. 基础镜像选用官方稳定版本镜像jenkins/jenkins:lts-jdk17

## 一.安装插件

### 1.安装指令

在很多情况下,制作出来的镜像会运行在没有网络的环境中,所以需要在制作镜像时,提前安装插件
执行指令
```shell
jenkins-plugin-cli --latest true --plugin-file /usr/share/jenkins/ref/plugins.txt
```

### 2.plugins.txt如何获取
文档地址： https://www.jenkins.io/doc/book/managing/plugins/

在已有的Jenkins中，通过脚本获取插件列表

```groovy
 Jenkins.instance.pluginManager.plugins.each {
      println("${it.getShortName()}: ${it.getVersion()}")
}
```