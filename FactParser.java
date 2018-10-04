import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class FactParser{
	private factRepository factList;
	public FactParser(){
	factList = new factRepository();
	}
	
	public factRepository getfactRepository(){
		return factList;
	}
	
	public void loadXmlDocument(String file){
		try{
			File inputFile = new File(file);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList factList = doc.getElementsByTagName("Fact");
			for(int i=0;i<factList.getLength(); i++){
				Node nFact = factList.item(i);
				Element eFact = (Element) nFact;
				Fact fact = new Fact(eFact.getAttribute("id"),((Element)eFact.getElementsByTagName("Description").item(0)).getAttribute("value"));
				NodeList evalList = eFact.getElementsByTagName("Eval");
				for(int j=0; j<evalList.getLength(); j++){
					Node nEval = evalList.item(j);
					Element eEval = (Element) nEval;
					boolean value=false;
					if(eEval.getTextContent().equals("true"))
						value=true;
					fact.setFactValueById(eEval.getAttribute("id"),value);
				}
			this.factList.addFact(fact);
			}
		}
		catch(Exception e){
			System.out.println("EXCEPTIONco!!!");
		}
	}
}