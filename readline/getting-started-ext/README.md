# Æsh Readline Getting Started Extended

In this example we're showing more of the capabilities in Æsh. We're enabling aliases and adding
specific handlers. With Æsh readline you can define handles for almost every event/action/input.
In this example we create a handler that's called when the connection to the terminal is lost, 
usually happens when CLI exits. We also define a custom signal handler to catch interrupts.

We also have added more logic to the input parsing.

## Requirements

To compile and run you need
- JDK 8 or later
- Apache Maven `3.5.+`

## Building

Launch the Maven build with:

> mvn install

## Running

For simplicity we use the Maven shade plugin to package all the dependencies into on jar, to run:

> java -jar target/readline-getting-started-ext-0.1.jar

