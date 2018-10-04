import java.util.ArrayList;
public class Question{
	private String question;
	private String id;
	private Answer answer=new Answer();
	
	Question(String question, String id){
		this.question=question;
		this.id=id;
		System.out.println(this.question);
	}
	
	public String getId(){
		return id;
	}
	
	public String getQuestion(){
		return question;
	}
	
	public void setAnswer(Answer answer){
		this.answer=answer;
	}
	
	public Answer getAnswer(){
		return answer;
	}
	
	public boolean getEvaluatedAnswer(){
		return this.answer.answer;
	}
	
}