# CONFLUENCE破解镜像制作与运行

## 1.先在本地进行镜像制作

```shell
docker build -t xxxx -f container/Dockerfile .
```

## 2.执行docker-compose

修改docker-compose中的镜像为步骤1中制作好的镜像

```shell
docker-compose up -d
```

## 3.问题记录

### 3-1.邮箱问题

在新版本中，邮箱的配置方式发生了变化，需要修改`/opt/atlassian/confluence/conf/server.xml`文件. 具体文件在conf目录下.

### 3-2.如何安装插件

1. 正常安装插件
2. 进入容器
```shell
docker exec -it xxxx /bin/bash
```
3. 执行语句
```shell
java -jar /var/atlassian/atlassian-agent.jar -d -m test@test.com -n BAT -p 'conf' -o http://localhost:8090 -s ${应用密钥}
```
4. 将执行完成的密钥,回填至界面