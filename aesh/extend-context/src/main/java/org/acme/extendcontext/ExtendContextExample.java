package org.acme.extendcontext;

import org.aesh.AeshRuntimeRunner;
import org.aesh.command.AeshCommandRuntimeBuilder;
import org.aesh.command.CommandRuntime;
import org.aesh.command.impl.registry.AeshCommandRegistryBuilder;
import org.aesh.command.registry.CommandRegistry;
import org.aesh.command.registry.CommandRegistryException;

public class ExtendContextExample {

    public static void main(String[] args) throws CommandRegistryException {

        CustomContext customContext = new CustomContext();

        CommandRegistry<CustomCommandInvocation> registry =
                AeshCommandRegistryBuilder.<CustomCommandInvocation>builder()
                        .command(CustomCommand.class)
                        .create();

        CommandRuntime<CustomCommandInvocation> runtime =
                AeshCommandRuntimeBuilder.<CustomCommandInvocation>builder()
                        .commandRegistry(registry)
                        .commandInvocationProvider(new CustomCommandInvocationProvider(customContext))
                        .build();

        AeshRuntimeRunner.builder().args(args).commandRuntime(runtime).execute();
    }

}

