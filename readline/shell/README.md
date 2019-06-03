# Æsh Readline Shell example

Here we've created a fairly simple shell program that have some defined commands.
Notice that the ShellExample itself is ignorant to which implementation of Connection it is using.

We'll reuse the `ShellExample` class in other examples when we'll set up SSH, Telnet and WebSockets.

## Requirements

To compile and run you need
- JDK 8 or later
- Apache Maven `3.5.+`

## Building

Launch the Maven build with:

> mvn install

## Running

For simplicity we use the Maven shade plugin to package all the dependencies into on jar, to run:

> java -jar target/shell-0.1.jar

