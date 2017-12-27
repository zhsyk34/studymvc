//package com.cat;
//
//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.server.handler.ContextHandler;
//
//public class Application {
//
//    public static void main(String[] args) {
//        Server server = new Server(8080);
//        // Add a single handler on context "/hello"
//        ContextHandler context = new ContextHandler();
//        context.setContextPath("/hello");
//        context.setHandler(new HelloHandler());
//        // Can be accessed using http://localhost:8080/hello
//        server.setHandler(context);
//        // Start the server
//        server.start();
//        server.join();
//    }
//}
