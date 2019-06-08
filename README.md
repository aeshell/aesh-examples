# Examples / Getting Started

This repository contains a set of examples for Æsh and Æsh-Readline.

## Æsh

* [Æsh Getting Started](./aesh/getting-started): Simple CLI example
* [Æsh Getting Started - Input](.aesh/getting-started-input): CLI example illustrating how commands handle input
* [Æsh Getting Started - Runtime](.aesh/getting-started-runtime): Simple Runtime example, showing how to execute a single command
* [Æsh Extend Context](.aesh/extend-context): Æsh supports creating custom `CommandInvocation` object types that can be used while executing commands.

## Readline

* [Readline Getting Started](./readline/getting-started): Simple readline example
* [Readline Getting Started - Extended](./readline/getting-started-ext): A larger readline example
* [Readline - Shell](./readline/shell): A simple shell
* [Readline - Snake](./readline/snake): Snake
* [Readline - SSH Shell](./readline/shell-ssh): The shell example over SSH
* [Readline - SSH Telnet](./readline/shell-telnet): The shell example over Telnet
* [Readline - SSH WebSoket](./readline/shell-websocket): The shell example over WebSocket
* [Readline - Command Mirror SSH](./readline/cmd-mirror-ssh): A simple readline application that will run try the input as commands on the OS. - this is not meant to be used in production as it is not safe without proper parsing of what commands to run.

## Prerequisite

* [Maven 3.5.+](https://maven.apache.org/install.html)
