package websocket;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/countUp")
public class CountUpServer {
	// countUp対象
	private static int count;

	private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();

	static {
		// 5sごとにインクリメントする
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				count++;
				broadcast();
			}
		};
		timer.schedule(task, 5000, 5000);
	}

	@OnOpen
	public void currentCount(Session session) {
		sessions.add(session);
	}

	@OnClose
	public void remove(Session session) {
		sessions.remove(session);
	}

	public static void broadcast() {
		sessions.forEach(session -> {
			session.getAsyncRemote().sendText("{\"count\":" + count + "}");
		});
	}
}
