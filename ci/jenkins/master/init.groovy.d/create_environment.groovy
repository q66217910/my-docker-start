#!/usr/bin/env groovy
import jenkins.model.*
import hudson.security.*
import hudson.slaves.*

def instance = Jenkins.getInstance()

def DOCKER_REGISTRY_URL = System.getenv('DOCKER_REGISTRY_URL')
def DOCKER_REPOSITORY_URL = System.getenv('DOCKER_REPOSITORY_URL')

println "==============创建环境变量========================"


// 获取或创建一个EnvironmentVariablesNodeProperty实例
def properties = instance.getGlobalNodeProperties();
def envVarsProp = properties.get(EnvironmentVariablesNodeProperty)

if (envVarsProp == null) {
    envVarsProp = new EnvironmentVariablesNodeProperty()
}

// 添加新的环境变量到属性列表
envVarsProp.getEnvVars().put("DEV_IN_BANK", "true")
if (DOCKER_REGISTRY_URL != null && DOCKER_REPOSITORY_URL != null) {
    envVarsProp.getEnvVars().put("DOCKER_PREFIX", DOCKER_REGISTRY_URL + "/" + DOCKER_REPOSITORY_URL)
}


properties.remove(envVarsProp.getClass())
properties.add(envVarsProp)

instance.save()

println "==============创建环境变量结束========================"