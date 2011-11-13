package guessNumber;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class User implements Observer {
	private String name = "";
	private int guess;
	GameSession session;

	public User() {
	}

	public int getGuess() {
		return guess;
	}

	public void setGuess(int myGuess) {
		this.guess = myGuess;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getName();
	}

	public String login() throws GameException {
		session = GameSession.addUser(this);
		return "greeting.xhtml";
	}

	public ArrayList<User> getMyHomies() {
		if (session != null) {
			return session.allUsers();
		} else {
			return null;
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {

	}
}
