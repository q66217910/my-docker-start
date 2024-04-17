# 如何热备份POSTGRESQL

## 一.官方文档

官方文档中已提供了pg_dump与pg_dumpall工具以完整的使用文档
https://www.postgresql.org/docs/current/backup.html

## 二.备份步骤

### 2-1. 准备pg_hba.conf文件

将访问都改为trust,即可免密执行后续指令

```
host     all             all             0.0.0.0/0               trust
host     all             all             ::/0                    trust
local    all             all                                     trust
host     all             all        127.0.0.1/32                 trust
host     all             all        ::1/128                      trust
```

文件准备完成后在docker-compose中挂载到/bitnami/postgresql/conf目录下

```
services:
  postgresql:
    volumes:
      - ./bitnami/postgresql/conf/:/bitnami/postgresql/conf
```

### 2-2. 准备.pgpass文件

pg_hba.conf的方式不够安全,若是对安全性有所要求,请尽量选择.pgpass

```
hostname:port:database:user:password
```

文件准备完成后在docker-compose中挂载到~/目录下

```
services:
  postgresql:
    volumes:
      - ./root/:~/
```

### 2-3. 执行备份指令（验证是否可备份）

执行之后就会开始备份,执行完成后会在当前目录生成备份文件

```shell
docker exec -it postgresql pg_dumpall -h localhost -U postgres | gzip > ./postgres-backup-$(date +%F).gz
```

### 2-4. 准备shell脚本

准备备份脚本backup.sh

```shell
cd ${backupPath}
docker exec -it postgresql pg_dumpall -h localhost -U postgres | gzip > ./postgres-backup-$(date +%F).gz
##备份完成移除历史3天以上的版本
find ${backupPath} -type f -name '*.gz' -mtime +3 -delete
```

### 2-5. 新增crontab

```crontab
0 0 * * * /bin/bash backup.sh 
```