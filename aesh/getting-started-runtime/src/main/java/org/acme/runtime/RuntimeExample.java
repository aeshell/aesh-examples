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
package org.acme.runtime;

import org.aesh.AeshRuntimeRunner;
import org.aesh.command.Command;
import org.aesh.command.CommandDefinition;
import org.aesh.command.CommandResult;
import org.aesh.command.invocation.CommandInvocation;
import org.aesh.command.option.Option;

public class RuntimeExample {

    public static void main(String[] args) {
        AeshRuntimeRunner.builder().command(RuntimeCommand.class).args(args).execute();
    }

    @CommandDefinition(name = "test", description = "Runtime example")
    public static class RuntimeCommand implements Command {

        @Option
        private String bar;

        @Option(hasValue = false)
        private boolean input;

        @Override
        public CommandResult execute(CommandInvocation commandInvocation) throws InterruptedException {
            if(input) {
              String answer = commandInvocation.getShell().readLine("What is the answer? ");
              commandInvocation.println("The answer is: "+answer);
            }
            else
              commandInvocation.println("Bar is set to: "+bar);
            return CommandResult.SUCCESS;
        }
    }
}
