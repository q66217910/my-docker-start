import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*

println "==============安装MAVEN工具开始========================"

def instance = Jenkins.getInstance()
def mavenTool = instance.getDescriptor("hudson.tasks.Maven")
def maven3 = new hudson.tasks.Maven.MavenInstallation("maven3", "/opt/maven/apache-maven-3.8.4") as java.lang.Object
mavenTool.installations += maven3
mavenTool.save()

println "==============安装MAVEN工具结束========================"

