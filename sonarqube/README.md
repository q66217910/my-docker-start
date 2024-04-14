由于sonarqube需要破解,所以需要在官方基础镜像的基础下进行构建。构建完成后使用破解的镜像进行部署

步骤1. docker build -t sonarqube-crack:8.9.2-community container/Dockerfile
步骤2：将构建出来的镜像填写到docker-compose.yaml中image里