# Data Transfer Project Starter Repository

This repository serves as a template for writing DTP extensions and deploying them to a sample Docker-based runtime.

The Gradle build is configured to create a Docker-based runtime that loads extensions from two fictitious services, Fabrikam and Contoso, that store a user's contacts. 
The fictitious services are used for expediency as they do not require OAuth and API keys to be setup. 

If you would like to create a runtime that supports live services from providers such as Facebook, Google, Instagram, Microsoft, etc., edit `demo-server/build.gradle` to include 
the appropriate extension dependencies (examples are commented out in the build file). Note if you add live services, you will need to update `demo-server/env.secrets` to include 
required secret keys (see `demo-server/env.secrets.template` for examples). 


## Prerequisites 

* Git
* JDK 8+
* Docker

## Clone

Clone this repository:

`git clone https://github.com/Metaform/data-transfer-starter/tree/master/demo-server .`

## Build

From the cloned repository directory:

`./gradlew clean shadowJar dockerize` (*Nix)  

or 

`gradlew clean shadowJar dockerize` (Windows)

## Configuration

Create an env.secrets file from demo-server/env.secrets.template or use the supplied one

## Using a Different Domain

If you want to use the demo server with a different domain, pass '-PappDomain=<address>' to the build, as in:

`./gradlew -PappDomain=10.0.0.9 clean shadowJar dockerize`

or

`gradlew -PappDomain=10.0.0.9 clean shadowJar dockerize`

Note the port may also be customized using '-PappPort'. If you change the port, be sure to update the Docker execute command in the following section. 

## Run

Execute the Docker image:

`docker run --rm -p 3000:443 -p 5005:5005 -p 8080:8080 --env-file demo-server/env.sample.secrets --name dtp-starter datatransferproject/starter`

and point your browser to:

[https://localhost:3000](https://localhost:3000)   

Note that the SSL certificate used for the demo server is a test one and your browser will likely prompt you with a warning.
`
## Debugging

To remotely debug the demo server process, connect your Java IDE to localhost:5005.



