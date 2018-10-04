import java.util.ArrayList;
import java.util.List;
public class factRepository{
	private List<Fact> factList;
	public factRepository(){
		factList = new ArrayList<Fact>();
	}
	public void addFact(Fact fact){
		factList.add(fact);
	}
	public String toString(){
		String myList="";
		for(Fact fact: factList)
			myList+=fact.toString();
		return myList;
	}
	public List<Fact> getFactList(){
		return this.factList;
	}
	
	

}