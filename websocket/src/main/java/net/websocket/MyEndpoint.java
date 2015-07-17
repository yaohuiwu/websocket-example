package net.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by wuyaohui on 15-2-5.
 */
@ServerEndpoint("/hello")
public class MyEndpoint {

    private Session session;

    @OnOpen
    public void onOpen(Session session){
        System.out.println("Open:" + session.getBasicRemote());
        this.session = session;
    }

    @OnMessage
    public void onMessage(String text){
        System.out.println("text:" + text);
        try{
            System.out.println("send: " + text);
            this.session.getBasicRemote().sendText(text);
        }catch (IOException e){
            e.printStackTrace();
        }

        if("START_PUSH".equalsIgnoreCase(text)){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        sendRandom(10);
                    }catch (IOException e){
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
    }

    @OnClose
    public void onClose(Session session){
        System.out.println("Close");
    }

    public void sendRandom(int times)throws IOException{
        for(int i=0; i<times; i++){
            session.getBasicRemote().sendText("" +Math.random());
        }
    }
}
