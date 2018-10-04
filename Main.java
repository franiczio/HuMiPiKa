public class Main{
	
	public static void main(String args[])
	{	
		FactParser a = new FactParser();
		a.loadXmlDocument("Facts.xml");
		RuleParser b = new RuleParser();
		b.loadXmlDocument("Rules.xml");
		ESProvider c= new ESProvider(b,a);
	}
	
	
}