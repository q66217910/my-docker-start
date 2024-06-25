#!/usr/bin/env groovy
import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*
import hudson.util.PersistedList
import jenkins.model.Jenkins
import jenkins.branch.*
import jenkins.plugins.git.*
import org.jenkinsci.plugins.workflow.multibranch.*
import com.cloudbees.hudson.plugins.folder.*
import jenkins.plugins.git.traits.CleanBeforeCheckoutTrait
import hudson.plugins.git.extensions.impl.CleanBeforeCheckout
import com.cloudbees.hudson.plugins.folder.computed.DefaultOrphanedItemStrategy


def initMultibranchPipelineStr = System.getenv('INIT_MULTIBRANCH_PIPELINE')
List<String> gitRepos = initMultibranchPipelineStr?.split(',')

println "==============新建流水线开始========================"

gitRepos.forEach { gitRepo ->
    def repoName = gitRepo.substring(gitRepo.lastIndexOf('/') + 1, gitRepo.indexOf('.git'))
    String jobName = "${repoName}" as String
    String jobDescription = "${gitRepo}" as String
    String credentialsId = "gitlab-builder"
    String jobScript = "Jenkinsfile"

    println "==============新建流水线${jobName}========================"

    // Create MultiBranch pipeline
    Jenkins jenkins = Jenkins.instance
    WorkflowMultiBranchProject mbp = jenkins.createProject(WorkflowMultiBranchProject.class, jobName)
    mbp.description = jobDescription
    mbp.getProjectFactory().setScriptPath(jobScript)

    // Add git repo
    String id = "unneeded-non-null-ID"
    String remote = gitRepo
    String includes = "*"
    String excludes = ""
    boolean ignoreOnPushNotifications = false
    GitSCMSource gitSCMSource = new GitSCMSource(id, remote, credentialsId, includes, excludes, ignoreOnPushNotifications)
    BranchSource branchSource = new BranchSource(gitSCMSource)

    //清理配置
    CleanBeforeCheckout cleanCheckout = new CleanBeforeCheckout()
    cleanCheckout.setDeleteUntrackedNestedRepositories(true)
    CleanBeforeCheckoutTrait cleanBeforeCheckoutTrait = new CleanBeforeCheckoutTrait(cleanCheckout)

    //设置配置
    gitSCMSource.setTraits([cleanBeforeCheckoutTrait])

    PersistedList sources = mbp.getSourcesList()
    sources.clear()
    sources.add(branchSource)

    //设置过期时间
    mbp.setOrphanedItemStrategy(new DefaultOrphanedItemStrategy(true,30,10))

    // Trigger initial build (scan)
    jenkins.getItem(jobName).scheduleBuild()

    jenkins.save()

}

