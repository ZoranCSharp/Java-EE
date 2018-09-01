package publish;

import java.io.IOException;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/hello")

public class HelloWebSocket {

	@OnOpen
	public void greetTheClient(Session session) {
		
		try {
			session.getBasicRemote().sendText("Hello stranger");
		}catch(IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
