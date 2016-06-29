package pl.kuranc.tutorials.xmltutorial;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLWriter {

	private String XMLFile;
	List <User> users = new Users().getUsers();
	

	public void setFile(String XMLFile) {
		this.XMLFile = XMLFile;
	}

	public void saveXMLFile() {
		// tworzymy XMLOutputFactory
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		// tworzymy XMLEventFactory
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		//zakoñczenie dla tagów
		XMLEvent end = eventFactory.createDTD("\n");
		

		// tworzymy  XMLEventWriter
		try {
			XMLEventWriter eventWriter = outputFactory
					.createXMLEventWriter(new FileOutputStream(XMLFile));

			//Start Document
			XMLEvent event = eventFactory.createStartDocument();
		    eventWriter.add(event);
		    eventWriter.add(end);
		    //Pierwszy tag 
		    event = eventFactory.createStartElement("","","users");
		    eventWriter.add(event);
		    eventWriter.add(end);
		    
		    for (User user:users){
		    	event = eventFactory.createStartElement("", "", "user");
		    	eventWriter.add(event);
		    	
		    	
		    	
		    	
		    	
		    }
		    
		    
		    //Zamkniêcie pierwszego Taga
		    eventWriter.add(eventFactory.createEndElement("", "", "users"));
		    //eventWriter.add(end);
			//End Document
		    event=eventFactory.createEndDocument();
			eventWriter.add(event);
			
			eventWriter.flush();
			eventWriter.close();
			
		} catch (FileNotFoundException | XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	private void createNode(XMLEventWriter eventWriter, String name, String value){
		
	}

}
