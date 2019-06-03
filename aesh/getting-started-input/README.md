# Æsh Getting Started Input

Similar to [Getting Started] (../getting-started) we define just one command named 'InputCommand'.

In `InputCommand` we have also added some options. In Æsh options are easily defined using different 
option annotations:

- org.aesh.command.option.Option, the default option type, maps to one value
- org.aesh.command.option.OptionList, specifies a list of values
- org.aesh.command.option.OptionGroup, specifies a map of values

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

To execute the input command, type input. Notice that we use the builtin exit command to have a simple way to 
exit the CLI.
