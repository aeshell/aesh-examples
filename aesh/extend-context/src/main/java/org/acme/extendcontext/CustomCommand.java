package org.acme.extendcontext;

import org.aesh.command.Command;
import org.aesh.command.CommandDefinition;
import org.aesh.command.CommandResult;
import org.aesh.command.option.Option;

@CommandDefinition(name = "test", description = "a test...")
public class CustomCommand implements Command<CustomCommandInvocation> {

    @Option(shortName = 'f', defaultValue = "foo", description = "some description of foo")
    private String foo;

    @Override
    public CommandResult execute(CustomCommandInvocation commandInvocation) {
        commandInvocation.println("Hi "+foo+"! - you are now using: "+commandInvocation.customContext().name());
        return CommandResult.SUCCESS;
    }
}


