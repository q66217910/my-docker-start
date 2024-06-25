import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*
import org.jenkinsci.plugins.workflow.libs.*
import jenkins.plugins.git.GitSCMSource

sharedLibraryRepo=System.getenv('SHARED_LIBRARY_REPO')
String credentialsId = "gitlab-builder"

println "==============设置共享仓库开始========================"

def instance = Jenkins.getInstance()

// 确保 Jenkins 实例处于锁定状态，以便安全地进行配置修改
instance.setQuietPeriod(0)
instance.save()

// 创建或更新全局的共享库配置
def libConfig = new LibraryConfiguration("spLibrary", new SCMSourceRetriever(new GitSCMSource(null, sharedLibraryRepo, credentialsId, "*", "", false))) as java.lang.Object
libConfig.setDefaultVersion("master")

// 全局变量中添加或更新共享库配置
def globalLibraries = GlobalLibraries.get()
globalLibraries.setLibraries([libConfig])
globalLibraries.save()

println "==============共享仓库设置成功: mySharedLibrary========================"

// 重置Jenkins实例的安静期
instance.setQuietPeriod(5)
instance.save()

println "==============设置共享仓库结束========================"