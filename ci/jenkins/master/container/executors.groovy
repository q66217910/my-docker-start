//启动执行脚本
import jenkins.model.*
import hudson.tools.*
import hudson.tools.InstallSourceProperty.*
import hudson.tools.JDKInstaller.*
import hudson.slaves.DumbSlave.*
import hudson.tools.JDKInstaller.JDKRevision.*

// 设置master节点执行器数量为0
Jenkins.instance.setNumExecutors(0) // Recommended to not run builds on the built-in node

//工具安装
def oracleJdk8 = new JDK('oracle-jdk8', '/opt/java/oracle-jdk8') as java.lang.Object
// 获取或创建全局工具配置
def toolInstallations = Jenkins.instance.getDescriptorByType(hudson.model.JDK.DescriptorImpl)
toolInstallations.add(oracleJdk8)
toolInstallations.save()