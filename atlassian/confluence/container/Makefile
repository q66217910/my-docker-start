.PHONY:  build push

REG_SERVER=docker.repo.swifer.co
IMAGE=atlassian/confluence-server
TAG=8.8.0-sp

all: push

build:
	docker build -t $(REG_SERVER)/$(IMAGE):$(TAG) .

push: build
	docker  push $(REG_SERVER)/$(IMAGE):$(TAG)


