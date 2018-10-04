import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
public class ESProvider{
	boolean iHaveNoCarForYou=true;
	RuleParser ruleParser;
	FactParser factParser;
	List<Fact> factList = new ArrayList<Fact>();
	List<Question> ruleList = new ArrayList<Question>();
	private HashMap<String, Boolean> answers;
	
	
	ESProvider(RuleParser ruleParser,FactParser factParser){
		this.ruleParser=ruleParser;
		this.factParser=factParser;
		factList=factParser.getfactRepository().getFactList();
		ruleList=ruleParser.getRuleRepository().getRuleList();
		answers=new HashMap<String,Boolean>();
		
		for(int i=0; i<ruleList.size();i++)
			this.answers.put(ruleList.get(i).getId(),ruleList.get(i).getEvaluatedAnswer());
		
		for(int i=0; i<factList.size();i++)
			if(factList.get(i).getEvals().equals(answers)){
				System.out.println("AUTO DLA CIEBIE TO: ");
				System.out.println(factList.get(i).getDescription());
				iHaveNoCarForYou=false;
			}
		if(iHaveNoCarForYou)
			System.out.println("I have no car for your needs... sorry m8");
		
	}
	
	
	

}