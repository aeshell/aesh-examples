# Æsh Readline Shell WebSocket

In this example we're reusing [ShellExample] (../shell), but instead of using `TerminalConnection`
we're setting up a WebSocket server connection listening on port 8080.

To connect to it, open the `src/main/resources/index.html` file with your browser.

## Requirements

To compile and run you need
- JDK 8 or later
- Apache Maven `3.5.+`

## Building

Launch the Maven build with:

> mvn install

## Running

For simplicity we use the Maven shade plugin to package all the dependencies into on jar, to run:

> java -jar target/shell-websocket-0.1.jar
