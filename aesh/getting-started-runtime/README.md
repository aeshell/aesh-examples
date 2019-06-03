# Æsh Getting Started Runtime

Æsh can also be set up to run just one command. It will try to parse all the parameters as normal and execute
the one command specified.

In this example we've created a simple command `RuntimeCommand` where we have defined two options:
`input`and `bar`. If `input` is provided as a parameter, the command will query the user for an answer, else it
will try to display the value of the input parameter `bar`.

## Requirements

To compile and run you need
- JDK 8 or later
- Apache Maven `3.5.+`

## Building

Launch the Maven build with:

> mvn install

## Running

For simplicity we use the Maven shade plugin to package all the dependencies into on jar, to run:

> java -jar target/getting-started-runtime0.1.jar --input
or
> java -jar target/getting-started-runtime0.1.jar --bar Foo

