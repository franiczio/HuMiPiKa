import java.util.ArrayList;
import java.util.HashMap;
public class Fact{
	private String id;
	private String description;
	private HashMap<String, Boolean> evals;
	
	public Fact(String id, String description){
		evals = new HashMap<>();
		this.id=id;
		this.description=description;
		
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	
	
	public void setFactValueById(String id, boolean value){
		this.evals.put(id,value);
	}
	
	public String toString(){
		String content="";
		return content="ID: "+this.id+"\n"+"Model: "+this.description+"\n"+this.evals+"\n";
	}
	public HashMap<String,Boolean> getEvals(){
		return evals;
	}
}