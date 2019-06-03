# Æsh Getting Started

This is a very small example where we define a command with a class named "HelloCommand".
The easiest way to define a command is by using the `@CommandDefinition` annotation where you specify
the command name and description. In addition, an Æsh command need to implement the `org.aesh.command.Command` 
interface.
The `org.aesh.command.Command` interface provides the `execute` method which is called by Æsh when that specific
command is "executed".

## Requirements

To compile and run you need
- JDK 8 or later
- Apache Maven `3.5.+`

## Building

Launch the Maven build with:

> mvn install

## Running

For simplicity we use the Maven shade plugin to package all the dependencies into on jar, to run:

> java -jar target/getting-started-0.1.jar

To execute the "hello" command, type "hello". Notice that we use the builtin exit command to have a simple 
way to exit the CLI.
