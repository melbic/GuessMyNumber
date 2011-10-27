package guessNumber;

import java.util.HashSet;

public class GameSession {
	private HashSet<User> users;
	private static GameSession currentSession;
	
	public GameSession()
	{
		users = new HashSet<User>(3);
	}
	
	public static GameSession getSession() {
		if(currentSession.users.size() == 3)
			currentSession = new GameSession();
		return currentSession;
	}
	
	public void addUser(User user) throws GameException {
		if (users.size() >= 3)
			throw new GameException("To many users in the game.");
		users.add(user);	
	}
	
}
