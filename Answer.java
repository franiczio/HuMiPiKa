import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
public class Answer{
	boolean answer=true;
	
	public Answer(){
	
	}
	
	
	public Answer(String answerOne, String answerTwo){
		this.answer=evaluateAnswerByInput(answerOne,answerTwo);
		}
		
	
	public boolean evaluateAnswerByInput(String answerOne,String answerTwo){
	Scanner input = new Scanner(System.in);
		String myAnswer="";
		while(!Arrays.asList(answerOne.split(",")).contains(myAnswer)&&!Arrays.asList(answerTwo.split(",")).contains(myAnswer)){
			myAnswer=input.nextLine();
	
		}
		if(Arrays.asList(answerOne.split(",")).contains(myAnswer))
			return true;
		else
			return false;
		
	}
	
	
	
	
}