# Æsh Readline Shell SSH

In this example we're reusing [ShellExample] (../shell), but instead of using `TerminalConnection`
we're setting up a SSH server connection listening on port 5000.

To connect to it:
> ssh username@localhost -p 5000

## Requirements

To compile and run you need
- JDK 8 or later
- Apache Maven `3.5.+`

## Building

Launch the Maven build with:

> mvn install

## Running

For simplicity we use the Maven shade plugin to package all the dependencies into on jar, to run:

> java -jar target/shell-ssh-0.1.jar
