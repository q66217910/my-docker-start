#!/usr/bin/env groovy
import jenkins.model.*
import hudson.security.*
import hudson.slaves.*

def instance = Jenkins.getInstance()

println "==============创建环境变量========================"


// 获取或创建一个EnvironmentVariablesNodeProperty实例
def properties = instance.getGlobalNodeProperties();
def envVarsProp = properties.get(EnvironmentVariablesNodeProperty)

if (envVarsProp == null) {
    envVarsProp = new EnvironmentVariablesNodeProperty()
}

// 添加新的环境变量到属性列表
envVarsProp.getEnvVars().put("DEV_IN_BANK", "true")

properties.remove(envVarsProp.getClass())
properties.add(envVarsProp)

instance.save()

println "==============创建环境变量结束========================"