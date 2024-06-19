import jenkins.*
import hudson.*
import hudson.model.*
import jenkins.model.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*

credentialId="gitlab-builder"
credentialDescription="builder user for gitlab"
credentialUser=System.getenv('BUILDER_USER')
credentialPassword=System.getenv('BUILDER_PASSWORD')

println "--> credentialUser ${credentialUser}"

def instance = Jenkins.getInstance()

global_domain = Domain.global()
credentials_store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()

credentials = new UsernamePasswordCredentialsImpl(
        CredentialsScope.GLOBAL,
        credentialId,
        credentialDescription,
        credentialUser,
        credentialPassword)

credentials_store.addCredentials(global_domain, credentials)
println "--> Added credential"