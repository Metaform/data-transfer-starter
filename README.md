# Data Transfer Project Starter Repository

This repository serves as a template for writing DTP extensions and deploying them to a sample Docker-based runtime.

## Prerequisites 

* JDK 8+
* Docker

## Build
`./gradlew dockerize`

## Configuration

Create an env.secrets file from demo-server/env.secrets.template

## Run

`
docker run --rm -p 3000:443 -p 5005:5005 -p 8080:8080 --env-file demo-server/env.secrets --name dtp-starter datatransferproject/starter
`


