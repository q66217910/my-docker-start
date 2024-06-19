//启动执行脚本
import jenkins.model.*

// 设置master节点执行器数量为0
Jenkins.instance.setNumExecutors(0) // Recommended to not run builds on the built-in node