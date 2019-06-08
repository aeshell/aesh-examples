package org.acme.extendcontext;

import org.aesh.command.CommandException;
import org.aesh.command.CommandNotFoundException;
import org.aesh.command.Executor;
import org.aesh.command.invocation.CommandInvocation;
import org.aesh.command.invocation.CommandInvocationConfiguration;
import org.aesh.command.parser.CommandLineParserException;
import org.aesh.command.shell.Shell;
import org.aesh.command.validator.CommandValidatorException;
import org.aesh.command.validator.OptionValidatorException;
import org.aesh.readline.Prompt;
import org.aesh.readline.action.KeyAction;

import java.io.IOException;

public class CustomCommandInvocation<CI extends CommandInvocation> implements CommandInvocation {

    private final CommandInvocation<CI> commandInvocation;
    private final CustomContext context;

    public CustomCommandInvocation(CommandInvocation<CI> commandInvocation, CustomContext context) {
        this.commandInvocation = commandInvocation;
        this.context = context;
    }

    @Override
    public Shell getShell() {
        return commandInvocation.getShell();
    }

    @Override
    public void setPrompt(Prompt prompt) {
        commandInvocation.setPrompt(prompt);
    }

    @Override
    public Prompt getPrompt() {
        return commandInvocation.getPrompt();
    }

    @Override
    public String getHelpInfo(String commandName) {
        return commandInvocation.getHelpInfo(commandName);
    }

    public String getHelpInfo() {
        return commandInvocation.getHelpInfo();
    }

    @Override
    public void stop() {
        commandInvocation.stop();
    }

    @Override
    public KeyAction input() throws InterruptedException {
        return commandInvocation.input();
    }

    @Override
    public String inputLine() throws InterruptedException {
        return commandInvocation.inputLine();
    }

    @Override
    public String inputLine(Prompt prompt) throws InterruptedException {
        return commandInvocation.inputLine(prompt);
    }

    @Override
    public void executeCommand(String input) throws CommandNotFoundException,
                                                            CommandLineParserException, OptionValidatorException,
                                                            CommandValidatorException, CommandException, InterruptedException, IOException {
        commandInvocation.executeCommand(input);
    }

    @Override
    public void print(String msg, boolean paging) {
        commandInvocation.print(msg, paging);
    }

    @Override
    public void println(String msg, boolean paging) {
        commandInvocation.println(msg, paging);
    }

    public CustomContext customContext() {
        return context;
    }

    @Override
    public Executor<CI> buildExecutor(String line) throws CommandNotFoundException,
            CommandLineParserException, OptionValidatorException, CommandValidatorException, IOException {
        return commandInvocation.buildExecutor(line);
    }

    public void print(String msg) {
        commandInvocation.print(msg);
    }

    public void println(String msg) {
        commandInvocation.println(msg);
    }

    @Override
    public CommandInvocationConfiguration getConfiguration() {
        return commandInvocation.getConfiguration();
    }
}
