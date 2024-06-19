#!/usr/bin/env groovy
import jenkins.model.*
import hudson.security.*

//默认设置admin账号
def instance = Jenkins.getInstance()

println "--> creating local user 'admin'"

def hudsonRealm = new HudsonPrivateSecurityRealm(false) as java.lang.Object
hudsonRealm.createAccount('admin','admin')
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy() as java.lang.Object
instance.setAuthorizationStrategy(strategy)

instance.save()