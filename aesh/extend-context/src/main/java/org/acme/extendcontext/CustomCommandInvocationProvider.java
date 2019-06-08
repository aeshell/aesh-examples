package org.acme.extendcontext;

import org.aesh.command.invocation.CommandInvocation;
import org.aesh.command.invocation.CommandInvocationProvider;

public class CustomCommandInvocationProvider implements CommandInvocationProvider<CustomCommandInvocation> {

    private final CustomContext context;

    CustomCommandInvocationProvider(CustomContext context) {
        this.context = context;
    }

    @Override
    public CustomCommandInvocation enhanceCommandInvocation(CommandInvocation commandInvocation) {
        return new CustomCommandInvocation(commandInvocation, context);
    }
}
