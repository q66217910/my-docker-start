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

// Project variables
List<String> gitRepos = ["https://github.com/Dirc/jenkins-init-groovy.git"]

gitRepos.forEach { gitRepo ->

    String jobName = "${gitRepo}" as String
    String jobDescription = "${gitRepo}" as String
    String credentialsId = "gitlab-builder"
    String jobScript = "Jenkinsfile"


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

    // Remove and replace?
    PersistedList sources = mbp.getSourcesList()
    sources.clear()
    sources.add(branchSource)

    // Trigger initial build (scan)
    jenkins.getItem(jobName).scheduleBuild()

    jenkins.save()

}

