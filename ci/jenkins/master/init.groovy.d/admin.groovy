#!/usr/bin/env groovy
import jenkins.model.*
import hudson.security.*

//默认设置admin账号
def instance = Jenkins.getInstance()

def admin = System.getenv('ADMIN_USER')
def password = System.getenv('ADMIN_PASSWORD')

println "==============创建admin用户开始========================"

def hudsonRealm = new HudsonPrivateSecurityRealm(false) as java.lang.Object
hudsonRealm.createAccount(admin,password)
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy() as java.lang.Object
instance.setAuthorizationStrategy(strategy)

instance.save()

println "==============创建admin用户结束========================"