package pl.kuranc.tutorials.xmltutorial;

public class TestWrite {

	public static void main(String[] args) {
		XMLWriter writer = new XMLWriter();
		writer.setFile("users2.xml");
		writer.saveXMLFile();
	}

}
