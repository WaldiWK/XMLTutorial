package pl.kuranc.tutorials.xmltutorial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLReader {
	static final String USER = "user";
	static final String NAME = "name";
	static final String SURNAME = "surname";
	static final String TITLE = "title";

	public List<User> reader(String filename) {
		List<User> users = new ArrayList<User>();
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		
		try {
			InputStream file = new FileInputStream(filename);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(file);
			User user = null;
			
			//przelatuje przez kolejne eventy
			while (eventReader.hasNext()){
				XMLEvent event = eventReader.nextEvent();
				
				//sprawdzamy czy element siê zaczyna np: <user>
				if (event.isStartElement()){
					StartElement startElement = event.asStartElement();
					if(startElement.getName().getLocalPart().equals(USER)){
						user = new User();
					}
				}
				
				if (event.isStartElement()){
					if(event.asStartElement().getName().getLocalPart().equals(NAME)){
						//skoro eventem by³o napodkanie startowego elementu np:<name>
						//to kolejnym zapewne bêdzie tekst
						event=eventReader.nextEvent();
						//pobieramy zawartoœæ tekstu
						String imie = event.asCharacters().getData();
						user.setImie(imie);
						continue;
					}	
				}
			
				if (event.isStartElement()){
					if(event.asStartElement().getName().getLocalPart().equals(SURNAME)){
						event=eventReader.nextEvent();
						user.setNazwisko(event.asCharacters().getData());
						continue;
					}	
				}
				if (event.isStartElement()){
					if(event.asStartElement().getName().getLocalPart().equals(TITLE)){
						event=eventReader.nextEvent();
						user.setTytlul(event.asCharacters().getData().toString());
						continue;
					}	
				}
			
				//sprawdzamy czy element siê koñczy np </user>
				if (event.isEndElement()){
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart().equals(USER)){
						users.add(user);
					}
					
				}			
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return users;

	}
}
