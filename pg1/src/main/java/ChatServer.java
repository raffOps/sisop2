import javax.websocket.server.ServerEndpoint;
import javax.websocket.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@ServerEndpoint("/chat")
public class ChatServer{
    private static ArrayList<Session> sessions = new ArrayList<>();
    private static final Logger LOGGER = Logger.getLogger( ChatServer.class.getName() );

    @OnOpen
    public void openSocket(Session session){
        sessions.add(session);
        LOGGER.log(Level.ALL, "Connection open:" + session.getId());

    }

    @OnClose
    public void closeSocket(Session session){
        sessions.remove(session);
        LOGGER.log(Level.ALL, "Connection closed:" + session.getId());
    }

    @OnMessage
    public void sendMessage(String message){
        for (Session session: sessions) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                LOGGER.log(Level.ALL, "Error: " + e.getMessage());
            }
        }
    }

}
