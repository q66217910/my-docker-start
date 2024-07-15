#!/usr/bin bash

    set -ex



    declare -A file_map # 定义关联数组

    ## 查询目录下所有的文件
    listFileString=$(find ./ -type f)

    echo "【done list recurse file】"

    # 检查变量是否为空，如果不为空则开始循环
    if [ -n "$listFileString" ]; then
      # 将换行符作为分隔符，读取每一项为一个文件路径
      while IFS= read -r file; do
        # 提取文件名
        filename=$(basename "$file")
        # 读取文件内容并转换为base64
        content_base64=$(base64 "$file")

        # 将文件名作为key，base64内容作为value，添加到关联数组中
        file_map["$filename"]=$content_base64
        # 输出当前处理的文件及其base64内容
        echo "Processing file: $file, base64 content: $content_base64"
      done <<< "$listFileString"
    fi

    secretContent="""
    kind: Secret
    apiVersion: v1
    metadata:
      name: $ARGOCD_APP_NAME-app-config
      namespace: $ARGOCD_APP_NAMESPACE
    data:
    """

    for key in "${!file_map[@]}"; do
        # 添加每一对键值到secretContent
        line=$(printf "%s: %s\n" "$key" "$(echo -n "${file_map[$key]}" | tr -d '\n')")
        secretContent+="\n      $line"
    done

     # 输出完整的secretContent
    echo -e "$secretContent"