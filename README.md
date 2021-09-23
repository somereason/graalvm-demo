# README

a demo for graalvm and springboot

## commands

generate config file by agent

> java -agentlib:native-image-agent=config-output-dir=src/main/resources/META-INF/native-image -jar target/graalvm-demo-0.0.1-SNAPSHOT.jar

then request following pages for a better coverage of dynamic accesses

```sh
curl http://localhost:9001/
curl http://localhost:9001/random_car
curl http://localhost:9001/indexjson
```

package

> mvn clean package -Dmaven.test.skip=true

run

> target/graalvm-demo

## TODO

* use freemarker
* use profile in pom(note: try to remove spring-boot-maven-plugin)
* config logs
* add static file, and read in app

