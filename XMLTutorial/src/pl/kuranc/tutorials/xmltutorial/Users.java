package pl.kuranc.tutorials.xmltutorial;

import java.util.List;

public class Users {
	private List<User> users;
	private User user;
	
	public Users(){
		users.add(setUser("John","Smith","mister"));
		users.add(setUser("Henry","Jekyll","doctor"));
		users.add(setUser("Albert","Einstein","professor"));		
	}
	
	private User setUser(String imie, String nazwisko, String tytul){
		user = new User();
		user.setImie(imie);
		user.setNazwisko(nazwisko);
		user.setTytlul(tytul);
		return user;
		
	}

	public List<User> getUsers(){
		return  users;
	}
}
