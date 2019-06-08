# Æsh Extend Context

Here we show how you can extend the `CommandInvocation` interface. This is very useful in a CLI environment
if you have the need of some custom context objects available for your commands.

## Requirements

To compile and run you need
- JDK 8 or later
- Apache Maven `3.5.+`

## Building

Launch the Maven build with:

> mvn install

## Running

For simplicity we use the Maven shade plugin to package all the dependencies into on jar, to run:

> java -jar target/extend-context-0.1.jar

