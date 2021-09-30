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

then remove following content in reflect-config.json

```json
{
  "name":"org.springframework.boot.logging.log4j2.Log4J2LoggingSystem$Factory",
  "methods":[{"name":"<init>","parameterTypes":[] }]
}
```

package

> mvn clean package -Dmaven.test.skip=true

run

> target/graalvm-demo

## init sql


```sql
create database test;

use test;

create table test.car
(
id int auto_increment
primary key,
plate varchar(20) null,
content json null
);

INSERT INTO test.car (plate, content) VALUES ('613138712310', '{"model":"BMW 750i"}');
INSERT INTO test.car (plate, content) VALUES ('570419857871', '{"model":"BMW 750i"}');
INSERT INTO test.car (plate, content) VALUES ('976078589320', '{"model":"BMW 750i"}');
INSERT INTO test.car (plate, content) VALUES ('857980252855', '{"model":"BMW 750i"}');
INSERT INTO test.car (plate, content) VALUES ('420925232621', '{"model":"BMW 750i"}');
```


## TODO

* use freemarker
* use profile in pom(note: try to remove spring-boot-maven-plugin)
* config logs
* add static file, and read in app

