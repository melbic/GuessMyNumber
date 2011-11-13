package guessNumber;

import java.util.HashSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SessionManager {

	
	private static SessionManager instance;
	static HashSet<GameSession> sessions;
	
	private SessionManager() {
	}

	public synchronized SessionManager getSession() {
		if (instance == null) {
			instance = new SessionManager();
		}
		return instance;
	}

	public static boolean add(GameSession current){
		return sessions.add(current);
	}
}
