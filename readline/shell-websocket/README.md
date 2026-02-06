# Æsh Readline Shell WebSocket

In this example we're reusing [ShellExample](../shell), but instead of using `TerminalConnection`
we're setting up a WebSocket server connection listening on port 8080.

The web terminal uses [xterm.js](https://github.com/xtermjs/xterm.js) loaded from CDN for the browser-based terminal emulation.

## Requirements

To compile and run you need:
- JDK 11 or later
- Apache Maven `3.5.+`

## Building

Launch the Maven build with:

```bash
mvn install
```

## Running

For simplicity we use the Maven shade plugin to package all the dependencies into one jar, to run:

```bash
java -jar target/shell-websocket-0.1.jar
```

Then open your browser to `http://localhost:8080` to connect to the WebSocket terminal.

## Features

The web terminal includes:
- Modern xterm.js terminal emulator
- Responsive sizing (adapts to browser window)
- Connection status indicator
- Cursor blinking
- Text selection support
