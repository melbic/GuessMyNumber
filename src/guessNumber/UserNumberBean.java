/*
 * Copyright 2011 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 * abgeaendert H. Rudin 15.10.11
 */

package guessNumber;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.*;



@ManagedBean
@SessionScoped
public class UserNumberBean {
	Integer randomInt = null;
	Integer userNumber = null;
	private long maximum = 10;
	private long minimum = 1;

	public UserNumberBean() {
		Random randomGR = new Random();
		randomInt = new Integer(randomGR.nextInt(10));
		System.out.println("Duke's number: " + randomInt);
	}

	public void setUserNumber(Integer user_number) {
		userNumber = user_number;
	}

	public Integer getUserNumber() {
		return userNumber;
	}

	public String check() {
		System.out.println("check() aufgerufen");
		if ((userNumber != null) && (userNumber.compareTo(randomInt) == 0)) {
			invalidateSession();
			return "correct.xhtml";
		} else {
			return "wrong.xhtml";
		}
	}

	private void invalidateSession() {
		System.out.println("Session invalidiert");
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();
	}

	public String giveup() {
		System.out.println("giveup() aufgerufen");
		invalidateSession();
		return "cancelled.xhtml";
	}

	public long getMaximum() {
		return (this.maximum);
	}

	public void setMaximum(long maximum) {
		this.maximum = maximum;
	}

	public long getMinimum() {
		return (this.minimum);
	}

	public void setMinimum(long minimum) {
		this.minimum = minimum;
	}
}
