import java.util.ArrayList;
import java.util.List;
public class ruleRepository{
	private List<Question> ruleList;
	public ruleRepository(){
		ruleList = new ArrayList<Question>();
	}
	public void addRule(Question rule){
		ruleList.add(rule);
	}
	
	public List<Question> getRuleList(){
		return this.ruleList;
	}
	
	
	

}