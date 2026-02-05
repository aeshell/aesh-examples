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
package org.acme.cmdmirrorssh;

import org.aesh.readline.Readline;
import org.aesh.readline.ReadlineBuilder;
import org.aesh.terminal.tty.TerminalConnection;
import org.aesh.terminal.Connection;
import org.aesh.terminal.tty.Signal;
import org.aesh.terminal.utils.Config;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.function.Consumer;

public class CmdMirror implements Consumer<Connection> {

    private String prompt;

    public static void main(String... args) throws IOException {
        //we're setting up readline to read when connection receives any input
        //note that this needs to be done after every time Readline.readline returns
        new TerminalConnection(new CmdMirror());
    }

    public CmdMirror() {
      this.prompt = "$ ";
    }

    public CmdMirror(String prompt) {
        if(prompt != null)
            this.prompt = prompt;
        else
            this.prompt = "$ ";
    }

    @Override
    public void accept(Connection connection) {
        read(connection, ReadlineBuilder.builder().enableHistory(false).build(), prompt);
        //setting our own signal handler for ctrl-c signals, lets close if we get any
        connection.setSignalHandler( signal -> {
            if(signal == Signal.INT)
                connection.write(Config.getLineSeparator());
                connection.close();
        });
        //lets open the connection to the terminal using this thread
        connection.openBlocking();
    }

    private void read(Connection connection, Readline readline, String prompt) {
        readline.readline(connection, prompt, input -> {
            if(input != null && (input.trim().equals("exit") || input.trim().equals("quit"))) {
                connection.close();
            }
            else {
              if(input != null && input.trim().length() > 0) {
                runCmd(connection, input);
              }
              read(connection, readline, prompt);
            }
        });
    }

    private void runCmd(Connection connection, String input) {
        Process process = null;
        try {
            process = new ProcessBuilder(input.split(" ")).start();

            InputStream is = process.getInputStream();
            process.waitFor();


            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            //System.out.println("Buffer: "+ Arrays.toString(buffer.toByteArray()));
            connection.write(new String(buffer.toByteArray()));

        }
        catch(InterruptedException e) {
            if(process != null)
                process.destroy();
        }
        catch(IOException e) {
            connection.write("Failed to invoke command: "+input+" Got Exception: "+e.toString()+"\n");
        }
    }
}
