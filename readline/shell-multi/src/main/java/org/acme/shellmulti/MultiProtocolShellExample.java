/*
 * JBoss, Home of Professional Open Source
 * Copyright 2017 Red Hat Inc. and/or its affiliates and other contributors
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
package org.acme.shellmulti;

import org.aesh.terminal.http.netty.NettyWebsocketTtyBootstrap;
import org.aesh.terminal.ssh.netty.NettySshTtyBootstrap;
import org.apache.sshd.server.keyprovider.AbstractGeneratorHostKeyProvider;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.acme.shell.ShellExample;

/**
 * Example demonstrating multiple connection protocols sharing the same shell.
 * <p>
 * This example starts both an SSH server and an HTTP/WebSocket server,
 * allowing users to connect via either protocol and get the same shell experience.
 * <p>
 * <b>Connection methods:</b>
 * <ul>
 *   <li>SSH: {@code ssh -p 5000 localhost}</li>
 *   <li>HTTP: Open {@code http://localhost:8080} in a browser</li>
 * </ul>
 *
 * @author Ståle W. Pedersen
 */
public class MultiProtocolShellExample {

    private static final int SSH_PORT = 5000;
    private static final int HTTP_PORT = 8080;
    private static final String HOST = "localhost";

    private NettySshTtyBootstrap sshBootstrap;
    private NettyWebsocketTtyBootstrap httpBootstrap;
    private final CountDownLatch shutdownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        new MultiProtocolShellExample().run();
    }

    public void run() throws Exception {
        // Create the shared shell handler
        ShellExample shellHandler = new ShellExample();

        // Start SSH server
        startSshServer(shellHandler);

        // Start HTTP/WebSocket server
        startHttpServer(shellHandler);

        // Print connection information
        printConnectionInfo();

        // Setup shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(this::shutdown));

        // Wait for shutdown
        shutdownLatch.await();
    }

    private void startSshServer(ShellExample shellHandler) throws Exception {
        // Generate or load host key
        AbstractGeneratorHostKeyProvider hostKeyProvider =
            new SimpleGeneratorHostKeyProvider(new File("hostkey.ser").toPath());
        hostKeyProvider.setAlgorithm("RSA");

        sshBootstrap = new NettySshTtyBootstrap()
            .setHost(HOST)
            .setPort(SSH_PORT)
            .setKeyPairProvider(hostKeyProvider);

        sshBootstrap.start(shellHandler).get(10, TimeUnit.SECONDS);
        System.out.println("SSH server started on " + HOST + ":" + SSH_PORT);
    }

    private void startHttpServer(ShellExample shellHandler) throws Exception {
        httpBootstrap = new NettyWebsocketTtyBootstrap()
            .setHost(HOST)
            .setPort(HTTP_PORT);

        httpBootstrap.start(shellHandler).get(10, TimeUnit.SECONDS);
        System.out.println("HTTP/WebSocket server started on " + HOST + ":" + HTTP_PORT);
    }

    private void printConnectionInfo() {
        System.out.println();
        System.out.println("===========================================");
        System.out.println("  Multi-Protocol Shell Example");
        System.out.println("===========================================");
        System.out.println();
        System.out.println("Connect via SSH:");
        System.out.println("  ssh -p " + SSH_PORT + " " + HOST);
        System.out.println();
        System.out.println("Connect via browser:");
        System.out.println("  http://" + HOST + ":" + HTTP_PORT);
        System.out.println();
        System.out.println("Press Ctrl+C to stop the servers.");
        System.out.println("===========================================");
        System.out.println();
    }

    private void shutdown() {
        System.out.println("\nShutting down servers...");

        try {
            if (httpBootstrap != null) {
                httpBootstrap.stop().get(5, TimeUnit.SECONDS);
                System.out.println("HTTP server stopped.");
            }
        } catch (Exception e) {
            System.err.println("Error stopping HTTP server: " + e.getMessage());
        }

        try {
            if (sshBootstrap != null) {
                sshBootstrap.stop().get(5, TimeUnit.SECONDS);
                System.out.println("SSH server stopped.");
            }
        } catch (Exception e) {
            System.err.println("Error stopping SSH server: " + e.getMessage());
        }

        shutdownLatch.countDown();
        System.out.println("Shutdown complete.");
    }
}
