import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class zabawaXML{

	public static void main(String args[]){	
	try{
		File inputFile = new File("Facts.xml");
	System.out.println("Hello World");	
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	/*StringBuilder xml = new StringBuilder();
	xml.append("<?xml version=\"1.0\"?> <class> </class>");
	ByteArrayInputStream input = new ByteArrayInputStream(xml.toString().getBytes("UTF-8"));*/
	Document doc = builder.parse(inputFile);
	//doc.getDocumentElement().normalize();
	System.out.println("Korzeń elementarny :" + doc.getDocumentElement().getNodeName()); // GET document element zwraca element główny. TZW KORZEŃ.
	System.out.println();
	NodeList nlist = doc.getElementsByTagName("Fact");		// metoda getElementsByTagName wpisuje do listy wszystkie elementy o podanej nazwie.
		for(int i=0; i<nlist.getLength(); i++){
			Node nNode = nlist.item(i);
			//System.out.println(nNode.getNodeType()==Node.ELEMENT_NODE);
			Element element = (Element) nNode;
			System.out.println(element.getAttribute("id"));
			System.out.println(((Element)element.getElementsByTagName("Description").item(0)).getAttribute("value"));
			//System.out.println(((Element)element.getElementsByTagName("Eval").item(1)).getAttribute("id"));
			System.out.println();
			NodeList Evals = element.getElementsByTagName("Eval");
			for(int j=0; j<Evals.getLength(); j++){
				Node eval = Evals.item(j);
				Element eEval = (Element) eval;
				System.out.println(eEval.getAttribute("id"));
				System.out.println(eEval.getTextContent());
			}
			System.out.println();
		}
	FactParser a= new FactParser();
	a.loadXmlDocument("Facts.xml");
	}
	catch(Exception e){
	System.out.println("JESTEŚ W BŁENDZIE");
	}
		
	
	}

}