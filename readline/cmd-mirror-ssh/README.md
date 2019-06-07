# Æsh Readline Command mirror

In this example we're trying to execute input as native commands. 

*WARNING* this is not safe to use in public production without parsing the input and verify which commands to run. 
This is meant as a simple example.

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

> java -jar target/cmd-mirror-ssh-0.1.jar
