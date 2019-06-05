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
package org.acme.shellwebsocket;

import org.aesh.terminal.http.netty.NettyWebsocketTtyBootstrap;

import java.util.concurrent.TimeUnit;

import org.acme.shell.ShellExample;

/**
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
public class WebSocketShellExample {

    public static synchronized void main(String[] args) throws Exception {
        NettyWebsocketTtyBootstrap bootstrap = new NettyWebsocketTtyBootstrap().setHost("localhost").setPort(8080);
        bootstrap.start(new ShellExample()).get(10, TimeUnit.SECONDS);
        System.out.println("Web server started on localhost:8080");
        WebSocketShellExample.class.wait();
    }
}
