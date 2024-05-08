# RABBITMQ快速搭建


### 1.common 单机模式

### 4.通用环境变量

| Name                                           | Description                                                                                                                                                                                      | Default Value                        |
|------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------|
| `RABBITMQ_CONF_FILE`                           | RabbitMQ configuration file.                                                                                                                                                                     | `${RABBITMQ_CONF_DIR}/rabbitmq.conf` |
| `RABBITMQ_DEFINITIONS_FILE`                    | Whether to load external RabbitMQ definitions. This is incompatible with setting the RabbitMQ password securely.                                                                                 | `/app/load_definition.json`          |
| `RABBITMQ_SECURE_PASSWORD`                     | Whether to set the RabbitMQ password securely. This is incompatible with loading external RabbitMQ definitions.                                                                                  | `no`                                 |
| `RABBITMQ_CLUSTER_NODE_NAME`                   | RabbitMQ cluster node name. When specifying this, ensure you also specify a valid hostname as RabbitMQ will fail to start otherwise.                                                             | `nil`                                |
| `RABBITMQ_CLUSTER_PARTITION_HANDLING`          | RabbitMQ cluster partition recovery mechanism.                                                                                                                                                   | `ignore`                             |
| `RABBITMQ_DISK_FREE_RELATIVE_LIMIT`            | Disk relative free space limit of the partition on which RabbitMQ is storing data.                                                                                                               | `1.0`                                |
| `RABBITMQ_DISK_FREE_ABSOLUTE_LIMIT`            | Disk absolute free space limit of the partition on which RabbitMQ is storing data (takes precedence over the relative limit).                                                                    | `nil`                                |
| `RABBITMQ_ERL_COOKIE`                          | Erlang cookie to determine whether different nodes are allowed to communicate with each other.                                                                                                   | `nil`                                |
| `RABBITMQ_VM_MEMORY_HIGH_WATERMARK`            | High memory watermark for RabbitMQ to block publishers and prevent new messages from being enqueued. Can be specified as an absolute or relative value (as percentage or value between 0 and 1). | `nil`                                |
| `RABBITMQ_LOAD_DEFINITIONS`                    | Whether to load external RabbitMQ definitions. This is incompatible with setting the RabbitMQ password securely.                                                                                 | `no`                                 |
| `RABBITMQ_MANAGEMENT_BIND_IP`                  | RabbitMQ management server bind IP address.                                                                                                                                                      | `0.0.0.0`                            |
| `RABBITMQ_MANAGEMENT_PORT_NUMBER`              | RabbitMQ management server port number.                                                                                                                                                          | `15672`                              |
| `RABBITMQ_MANAGEMENT_ALLOW_WEB_ACCESS`         | Allow web access to RabbitMQ management portal for RABBITMQ_USERNAME                                                                                                                             | `false`                              |
| `RABBITMQ_NODE_NAME`                           | RabbitMQ node name.                                                                                                                                                                              | `rabbit@localhost`                   |
| `RABBITMQ_USE_LONGNAME`                        | Whether to use fully qualified names to identify nodes                                                                                                                                           | `false`                              |
| `RABBITMQ_NODE_PORT_NUMBER`                    | RabbitMQ node port number.                                                                                                                                                                       | `5672`                               |
| `RABBITMQ_NODE_TYPE`                           | RabbitMQ node type.                                                                                                                                                                              | `stats`                              |
| `RABBITMQ_VHOST`                               | RabbitMQ vhost.                                                                                                                                                                                  | `/`                                  |
| `RABBITMQ_VHOSTS`                              | List of additional virtual host (vhost).                                                                                                                                                         | `nil`                                |
| `RABBITMQ_CLUSTER_REBALANCE`                   | Rebalance the RabbitMQ Cluster.                                                                                                                                                                  | `false`                              |
| `RABBITMQ_CLUSTER_REBALANCE_ATTEMPTS`          | Max attempts for the rebalance check to run                                                                                                                                                      | `100`                                |
| `RABBITMQ_USERNAME`                            | RabbitMQ user name.                                                                                                                                                                              | `user`                               |
| `RABBITMQ_PASSWORD`                            | RabbitMQ user password.                                                                                                                                                                          | `bitnami`                            |
| `RABBITMQ_FORCE_BOOT`                          | Force a node to start even if it was not the last to shut down                                                                                                                                   | `no`                                 |
| `RABBITMQ_ENABLE_LDAP`                         | Enable the LDAP configuration.                                                                                                                                                                   | `no`                                 |
| `RABBITMQ_LDAP_TLS`                            | Enable secure LDAP configuration.                                                                                                                                                                | `no`                                 |
| `RABBITMQ_LDAP_SERVERS`                        | Comma, semi-colon or space separated list of LDAP server hostnames.                                                                                                                              | `nil`                                |
| `RABBITMQ_LDAP_SERVERS_PORT`                   | LDAP servers port.                                                                                                                                                                               | `389`                                |
| `RABBITMQ_LDAP_USER_DN_PATTERN`                | DN used to bind to LDAP in the form cn=$${username},dc=example,dc=org.                                                                                                                           | `nil`                                |
| `RABBITMQ_NODE_SSL_PORT_NUMBER`                | RabbitMQ node port number for SSL connections.                                                                                                                                                   | `5671`                               |
| `RABBITMQ_SSL_CACERTFILE`                      | Path to the RabbitMQ server SSL CA certificate file.                                                                                                                                             | `nil`                                |
| `RABBITMQ_SSL_CERTFILE`                        | Path to the RabbitMQ server SSL certificate file.                                                                                                                                                | `nil`                                |
| `RABBITMQ_SSL_KEYFILE`                         | Path to the RabbitMQ server SSL certificate key file.                                                                                                                                            | `nil`                                |
| `RABBITMQ_SSL_DEPTH`                           | Maximum number of non-self-issued intermediate certificates that may follow the peer certificate in a valid certification path.                                                                  | `nil`                                |
| `RABBITMQ_SSL_FAIL_IF_NO_PEER_CERT`            | Whether to reject TLS connections if client fails to provide a certificate.                                                                                                                      | `no`                                 |
| `RABBITMQ_SSL_VERIFY`                          | Whether to enable peer SSL certificate verification. Valid values: verify_none, verify_peer.                                                                                                     | `verify_none`                        |
| `RABBITMQ_MANAGEMENT_SSL_PORT_NUMBER`          | RabbitMQ management server port number for SSL/TLS connections.                                                                                                                                  | `15671`                              |
| `RABBITMQ_MANAGEMENT_SSL_CACERTFILE`           | Path to the RabbitMQ management server SSL CA certificate file.                                                                                                                                  | `$RABBITMQ_SSL_CACERTFILE`           |
| `RABBITMQ_MANAGEMENT_SSL_CERTFILE`             | Path to the RabbitMQ server SSL certificate file.                                                                                                                                                | `$RABBITMQ_SSL_CERTFILE`             |
| `RABBITMQ_MANAGEMENT_SSL_KEYFILE`              | Path to the RabbitMQ management server SSL certificate key file.                                                                                                                                 | `$RABBITMQ_SSL_KEYFILE`              |
| `RABBITMQ_MANAGEMENT_SSL_DEPTH`                | Maximum number of non-self-issued intermediate certificates that may follow the peer certificate in a valid certification path, for the RabbitMQ management server.                              | `nil`                                |
| `RABBITMQ_MANAGEMENT_SSL_FAIL_IF_NO_PEER_CERT` | Whether to reject TLS connections if client fails to provide a certificate for the RabbitMQ management server.                                                                                   | `yes`                                |
| `RABBITMQ_MANAGEMENT_SSL_VERIFY`               | Whether to enable peer SSL certificate verification for the RabbitMQ management server. Valid values: verify_none, verify_peer.                                                                  | `verify_peer`                        |

#### Read-only environment variables

| Name                          | Description                                            | Value                                                             |
|-------------------------------|--------------------------------------------------------|-------------------------------------------------------------------|
| `RABBITMQ_VOLUME_DIR`         | Persistence base directory.                            | `/bitnami/rabbitmq`                                               |
| `RABBITMQ_BASE_DIR`           | RabbitMQ installation directory.                       | `/opt/bitnami/rabbitmq`                                           |
| `RABBITMQ_BIN_DIR`            | RabbitMQ executables directory.                        | `${RABBITMQ_BASE_DIR}/sbin`                                       |
| `RABBITMQ_DATA_DIR`           | RabbitMQ data directory.                               | `${RABBITMQ_VOLUME_DIR}/mnesia`                                   |
| `RABBITMQ_CONF_DIR`           | RabbitMQ configuration directory.                      | `${RABBITMQ_BASE_DIR}/etc/rabbitmq`                               |
| `RABBITMQ_DEFAULT_CONF_DIR`   | RabbitMQ default configuration directory.              | `${RABBITMQ_BASE_DIR}/etc/rabbitmq.default`                       |
| `RABBITMQ_CONF_ENV_FILE`      | RabbitMQ configuration file for environment variables. | `${RABBITMQ_CONF_DIR}/rabbitmq-env.conf`                          |
| `RABBITMQ_HOME_DIR`           | RabbitMQ home directory.                               | `${RABBITMQ_BASE_DIR}/.rabbitmq`                                  |
| `RABBITMQ_LIB_DIR`            | RabbitMQ lib directory.                                | `${RABBITMQ_BASE_DIR}/var/lib/rabbitmq`                           |
| `RABBITMQ_INITSCRIPTS_DIR`    | RabbitMQ init scripts directory.                       | `/docker-entrypoint-initdb.d`                                     |
| `RABBITMQ_LOGS_DIR`           | RabbitMQ logs directory.                               | `${RABBITMQ_BASE_DIR}/var/log/rabbitmq`                           |
| `RABBITMQ_PLUGINS_DIR`        | RabbitMQ plugins directory.                            | `${RABBITMQ_BASE_DIR}/plugins`                                    |
| `RABBITMQ_MOUNTED_CONF_DIR`   | RabbitMQ directory for mounted configuration files.    | `${RABBITMQ_VOLUME_DIR}/conf`                                     |
| `RABBITMQ_DAEMON_USER`        | RabbitMQ system user name.                             | `rabbitmq`                                                        |
| `RABBITMQ_DAEMON_GROUP`       | RabbitMQ system user group.                            | `rabbitmq`                                                        |
| `RABBITMQ_MNESIA_BASE`        | Path to RabbitMQ mnesia directory.                     | `$RABBITMQ_DATA_DIR`                                              |
| `RABBITMQ_COMBINED_CERT_PATH` | Path to the RabbitMQ server SSL certificate key file.  | `${RABBITMQ_COMBINED_CERT_PATH:-/tmp/rabbitmq_combined_keys.pem}` |
