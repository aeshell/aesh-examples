# Æsh Native Example Runtime

Here we show a simple way of using GraalVM against a Æsh runtime example to create a binary executable.
For this example to work you need to have GraalVM installed and the environmental variable `GRAALVM_HOME` set to
the directory it was installed.

Note that if you use GraalVM 19 or later you also need to manually install the `native-image`binary by doing:

> cd $GRAALVM_HOME/bin; gu install native-image

To build the native image, we've created a build profile named *native*. To trigger that profile we do:

> mvn install -Pnative

This will create a binary in the target folder called *aesh-native-runtime-0.1*. Run it with:

> target/aesh-native-runtime-0.1

Note that Æsh uses reflection so it needs to generate a JSON file that is given to GraalVM to specify
which classes that is. Luckily Æsh have a tool to build that file for you. In the `pom.xml` we trigger
that tool before we call the native-image generation. The JSON file generated is written to `target/native_reflection.json`.

In this example we've created a simple command `NativeCommand` where we have defined three options:
`input`, `bar` and `help`.
If no options are given, the help information will be displayed.

## Requirements

To compile and run you need
- JDK 8 ang GraalVM 1.0 RC12 later
- Apache Maven `3.5.+`

## Building

Launch the Maven build with (without native):

> mvn install

## Running

For simplicity we use the Maven shade plugin to package all the dependencies into on jar, to run:

> target/aesh-native-started-runtime-0.1.jar

