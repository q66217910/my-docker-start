import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*
import hudson.slaves.*
import hudson.util.*


nodeNum = Integer.parseInt(System.getenv('NODE_NUM'))

println "==============新建子节点开始========================"

def instance = Jenkins.getInstance()

for (i = 1; i < nodeNum + 1; i++) {
    // 配置代理节点的参数
    def nodeParams = [
            name             : "node${i}",
            remoteFS         : '/home/jenkins/workspace', // 代理节点上的工作空间路径
            labels           : 'maven', // 为节点分配的标签
            mode             : Node.Mode.NORMAL,
            retentionStrategy: RetentionStrategy.Always.INSTANCE, // 保留策略，这里始终保留
            numExecutors     : "4", // 节点上可用的执行器数量
    ] as java.lang.Object

    // 配置JNLP连接方式
    def jnlpLauncher = new JNLPLauncher("") as java.lang.Object

    // 创建节点
    def slave = new DumbSlave(nodeParams.name.toString(), nodeParams.name.toString(), nodeParams.remoteFS, nodeParams.numExecutors, nodeParams.mode, nodeParams.labels, jnlpLauncher, nodeParams.retentionStrategy) as java.lang.Object
    instance.addNode(slave)

    // 保存配置
    instance.save()
}


println "==============新建子节点结束========================"