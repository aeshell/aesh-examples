# Æsh Readline Getting Started

Æsh Readline is a library to support different input protocols. The default is native terminal input/output,
but it also have implemented support for SSH, Telnet and WebSockets.

In this example we're setting up a native terminal connection where we just print out the input 
(except when we get `exit`as the input, then we exit).

## Requirements

To compile and run you need
- JDK 8 or later
- Apache Maven `3.5.+`

## Building

Launch the Maven build with:

> mvn install

## Running

For simplicity we use the Maven shade plugin to package all the dependencies into on jar, to run:

> java -jar target/readline-getting-started-0.1.jar

