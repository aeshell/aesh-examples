# Æsh Readline Shell Telnet

In this example we're reusing [ShellExample] (../shell), but instead of using `TerminalConnection`
we're setting up a Telnet server connection listening on port 4000.

To connect to it:
> telnet localhost 4000

## Requirements

To compile and run you need
- JDK 8 or later
- Apache Maven `3.5.+`

## Building

Launch the Maven build with:

> mvn install

## Running

For simplicity we use the Maven shade plugin to package all the dependencies into on jar, to run:

> java -jar target/shell-telnet-0.1.jar
