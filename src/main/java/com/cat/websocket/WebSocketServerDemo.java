package com.cat.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

// @ServerEndpoint注解,标示出这是一个WebSocket的Server端 , value属性表示访问这个server的url
@ServerEndpoint(value = "/websocket/{user}")
public class WebSocketServerDemo {

    private static Set<Session> peers = new HashSet<>();

    private Session session;

    //  向所有客户端发送一条消息
    public static void broadcase(String msg) {

        System.out.println("WebSocketserverDemo broadcase ");
        for (Session session : peers) {
            try {
                session.getBasicRemote().sendText("这是我（服务器）向你们（客户端）推送的消息，不要惊讶");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //  open方法的注解，当一个客户端连上来时触发，每个客户端会被分配一个session,这个session可不是httpsession.
//  open方法里有个参数user被加上了注解@PathParam(value = "user")String user,这个就是从url中获取user的方式
    @OnOpen
    public void open(Session session, @PathParam(value = "user") String user) {
        this.session = session;
//      存储这个新session
        peers.add(session);

        System.out.println("WebSocketServerDemo open from sessionId:" + this.session.getId());
    }

    //  收到客户端发送的消息时触发
    @OnMessage
    public void inMessage(String message) {
        System.out.println("WebSocketServerDemo inmessage from sessionId:" + this.session.getId() +
                ":" + message);

    }

    //  客户端断开时触发
    @OnClose
    public void end() {
        System.out.println("WebSocketServerDemo end from sessionId:" + this.session.getId());
    }
}