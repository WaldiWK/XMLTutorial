package pl.kuranc.tutorials.xmltutorial.sax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxSimpleTutorial {

	public SaxSimpleTutorial() {
		SAXParserFactory factory = SAXParserFactory.newInstance();

		InputStream xmlInput;
		try {
			xmlInput = new FileInputStream("users.xml");
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new SaxHandler();
			saxParser.parse(xmlInput, handler);
		} catch (Throwable e) {
			
		//	e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		SaxSimpleTutorial tutorial = new SaxSimpleTutorial();

	}

	private class SaxHandler extends DefaultHandler {
		
		public void startDocument() throws SAXException {
	        System.out.println("start document   : ");
	    }

	    public void endDocument() throws SAXException {
	        System.out.println("end document     : ");
	    }

	    public void startElement(String uri, String localName,
	        String qName, Attributes attributes)
	    throws SAXException {

	        System.out.println("start element    : " + qName);
	    }

	    public void endElement(String uri, String localName, String qName)
	    throws SAXException {
	        System.out.println("end element      : " + qName);
	    }

	    public void characters(char ch[], int start, int length)
	    throws SAXException {
	        System.out.println("start characters : " +
	            new String(ch, start, length));
	    }

	}

}
