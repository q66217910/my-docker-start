import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*

println "==============安装JDK工具开始========================"

def instance = Jenkins.getInstance()
def jdkTool = instance.getDescriptor("hudson.model.JDK")

def oracleJdk8 = new JDK("oracle-jdk8", "/opt/java/oracle-jdk8") as java.lang.Object;
def openjdk17 = new JDK("jdk17", "/opt/java/openjdk") as java.lang.Object;

jdkTool.setInstallations(oracleJdk8,openjdk17)
jdkTool.save()

println "==============安装JDK工具结束========================"