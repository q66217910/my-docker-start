# spinnaker 部署

## 密文文件的使用

### 1.安装ksops

https://github.com/viaduct-ai/kustomize-sops/releases

### 2.安装sops

设置公钥： export SOPS_AGE_RECIPIENTS=age1hyhskz7u7kxw6q5wzgw5502u4z26hz5rjv903stlmcdeqt9t9uts84ru0m

https://github.com/getsops/sops/releases

### 3.安装age

https://github.com/FiloSottile/age/releases

### 4.使用加解密

**PS: 注意需要配置~/sops/age/keys.txt,文件我们只需要加密过的文件,原文件可以不上传,修改时进行解密后再修改**

加密
```shell
sops -e files-patch.dec.yaml --unencrypted-regex '^(apiVersion|metadata|kind|type)$'  > files-patch.enc.yaml
```

解密
```shell
sops -d files-patch.enc.yaml > files-patch.dec.yaml
```

## 部署spinnaker

### 1.执行CRD
```shell
kubectl.exe apply -f crd/spinnaker.io_spinnakeraccounts.yaml -n spinnaker
kubectl.exe apply -f crd/spinnaker.io_spinnakerservices.yaml -n spinnaker
```