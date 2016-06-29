/**
 * 
 */
package pl.kuranc.tutorials.xmltutorial;

import java.util.List;

/**
 * @author wkura
 *
 */
public class TestRead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Tworzymy parser i wczytujemy plik XML
		XMLReader userParser = new XMLReader();
		List<User> users = userParser.reader("users.xml");
		
		//wypisujemy uzytkowników z za³adowanego pliku
		for (User user : users) {
			System.out.print("nowy user \n");
			System.out.println(user.toString());
			
		}
		
	}

}
