import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class RuleParser{
	private ruleRepository ruleList;
	public RuleParser(){
	ruleList = new ruleRepository();
	}
	
	public ruleRepository getRuleRepository(){
		return ruleList;
	}
	
	public void loadXmlDocument(String file){
		try{
			File inputFile = new File(file);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(inputFile);
			doc.getDocumentElement().normalize();
			//System.out.println(doc.getDocumentElement().getNodeName());
			NodeList ruleList = doc.getElementsByTagName("Rule");
			for(int i=0; i<ruleList.getLength();i++){
				Node nRule = ruleList.item(i);
				Element eRule = (Element) nRule;
				Element answer = (Element)eRule.getElementsByTagName("Answer").item(0);
				Element selection1 = (Element)answer.getElementsByTagName("Selection").item(0);
				Element selection2 = (Element)answer.getElementsByTagName("Selection").item(1);
				Element answer1 = (Element)selection1.getElementsByTagName("SingleValue").item(0);
				Element answer2 = (Element)selection2.getElementsByTagName("SingleValue").item(0);
				if(answer1==null&&answer2==null){
					answer1 = (Element)selection1.getElementsByTagName("MultipleValue").item(0);
					answer2 = (Element)selection2.getElementsByTagName("MultipleValue").item(0);
				}
				String answerOne = answer1.getAttribute("value");
				String answerTwo = answer2.getAttribute("value");
				Question question = new Question(((Element)eRule.getElementsByTagName("Question").item(0)).getTextContent(),eRule.getAttribute("id"));
				System.out.println(answerOne);
				System.out.println(answerTwo);
				question.setAnswer(new Answer(answerOne,answerTwo));
				this.ruleList.addRule(question);
			}
			
			
		}
		catch (Exception e){
			System.out.println(e);
		}
	}	
	public static void main(String args[]){
		System.out.println("Hello World");
		RuleParser a = new RuleParser();
		a.loadXmlDocument("Rules.xml");
		
	}
}