package pl.kuranc.tutorials.xmltutorial.sax;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxComplexParser {
	 public static void main (String argv []) {
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        try {
	            InputStream    xmlInput  =
	                new FileInputStream("data\\saxComplexExample.xml");

	            SAXParser      saxParser = factory.newSAXParser();
	            SaxComplexHandler handler   = new SaxComplexHandler();
	            saxParser.parse(xmlInput, handler);

	            for(Driver driver : handler.drivers){
	                System.out.println(driver);
	            }
	        } catch (Throwable err) {
	            err.printStackTrace ();
	        }
	    }
}
