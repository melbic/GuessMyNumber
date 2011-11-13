package guessNumber;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class GameSession extends Observable {
	private ArrayList<User> users;
	private int randNumber;
	private static GameSession currentSession;

	public GameSession() {
		users = new ArrayList<User>();
		Random randomGR = new Random();
		randNumber = new Integer(randomGR.nextInt(100));
		System.out.println("The random Number is: " + randNumber);
	}
	
	private static GameSession getCurrentSession() {
		if (currentSession == null || currentSession.users.size() == 3)
			currentSession = new GameSession();
		return currentSession;
	}

	public static synchronized GameSession addUser(User user)
			throws GameException {
		GameSession session = getCurrentSession();
		session.users.add(user);
		return session;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> allUsers) {
		this.users = allUsers;
	}

	public boolean isFull() {
		return users.size() >= 3;
	}

	public boolean hasUser(String newUser) {
		return users.contains(newUser);
	}

	public ArrayList<User> allUsers() {
		return users;
	}

}
