//启动执行脚本
import jenkins.model.*
import hudson.model.*
import hudson.tasks.*


// 设置master节点执行器数量为0
Jenkins.instance.setNumExecutors(0) // Recommended to not run builds on the built-in node

//工具安装
def oracleJdk8 = new hudson.model.JDK('oracle-jdk8', '/opt/java/oracle-jdk8') as java.lang.Object
def openjdk17 = new hudson.model.JDK('jdk17', '/opt/java/openjdk') as java.lang.Object

def maven3 = new  hudson.tasks.MAVEN('maven3', '/opt/maven/apache-maven-3.8.4') as java.lang.Object
// 获取或创建全局工具配置
def toolInstallations = Jenkins.instance.getDescriptorByType(hudson.model.JDK.DescriptorImpl)
toolInstallations.add(oracleJdk8)
toolInstallations.add(openjdk17)
toolInstallations.add(maven3)
toolInstallations.save()