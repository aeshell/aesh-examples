/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.acme.quickstart;

import org.aesh.AeshConsoleRunner;
import org.aesh.command.Command;
import org.aesh.command.CommandDefinition;
import org.aesh.command.CommandResult;
import org.aesh.command.invocation.CommandInvocation;

/**
 * Input example
 */
public class InputExample {

    public static void main(String[] args) {
        AeshConsoleRunner.builder()
                .command(InputCommand.class)
                .prompt("[simple@aesh]$ ")
                .addExitCommand()
                .start();
    }

    @CommandDefinition(name = "input", 
                       description = "Shows some of the capabilities for collecting input when executing a command")
    public static class InputCommand implements Command {
        @Override
        public CommandResult execute(CommandInvocation commandInvocation) {
            commandInvocation.println("Hello from Aesh!");
            return CommandResult.SUCCESS;
        }
    }
}
