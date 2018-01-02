package com.cat.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppConsumer {

    private static final String url = "tcp://10.253.177.16:61616";
    private static final String queueName = "queue-test";

    public static void main(String[] args) throws JMSException {
        //1.创建连接工程ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        //2. 创建Connection
        Connection connection = connectionFactory.createConnection();

        //3.启动连接
        connection.start();

        //4.创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //5.创建目的地
        //Queue createQueue = session.createQueue(queueName);
        Destination destination = session.createQueue(queueName);

        //6.创建一个消费者
        MessageConsumer consumer = session.createConsumer(destination);

        //7.创建一个监听器
        consumer.setMessageListener(message -> {
            // 8.接收到的消息
            TextMessage textMessage = (TextMessage) message;
            //log
            try {
                System.out.println("接收消息 ：" + textMessage.getText());
            } catch (JMSException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        //9.关闭连接
        //session.close();
    }
}