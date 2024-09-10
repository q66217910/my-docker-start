METADATA=https://repo.swifer.co/artifactory/snapshots/cn/swiftpass/sppay-acc-task-war/maven-metadata.xml

curl -u "de.zhang@swiftpass.cn:AKCp8pQmDkoKWoU8HSeK887oZRXirFvysjg6FuqwAq6RfNXJKzt1fDPy7GpB1eYcqCRNmBi95" -X GET  "$METADATA"   -H 'Content-Type:application/json' -o maven-metadata.xml

curl -u "de.zhang@swiftpass.cn:AKCp8pQmDkoKWoU8HSeK887oZRXirFvysjg6FuqwAq6RfNXJKzt1fDPy7GpB1eYcqCRNmBi95" -T maven-metadata.xml "$METADATA"

rm -rf maven-metadata.xml