package source;

import java.util.HashMap;

public class OcrDictionary{

	public final static HashMap<String, Integer> ocrDictionary = new HashMap<String, Integer>();
	static{
		ocrDictionary.put("   ",1);
		ocrDictionary.put(" _ ",2);
		ocrDictionary.put("  |",3);
		ocrDictionary.put(" _|",4);
		ocrDictionary.put("|_|",5);
		ocrDictionary.put("|_ ",6);
	}
	
	public final static HashMap<String, String> numericTranslator = new HashMap<String, String>();
	static{
		numericTranslator.put("133","1");
		numericTranslator.put("246","2");
		numericTranslator.put("244","3");
		numericTranslator.put("153","4");
		numericTranslator.put("264","5");
		numericTranslator.put("265","6");
		numericTranslator.put("233","7");
		numericTranslator.put("255","8");
		numericTranslator.put("254","9");
	}
}