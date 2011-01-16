package test;


import java.util.Vector;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import source.OcrReader;

public class OCRKataTest extends TestCase{

	@Before
	public void setUp() throws Exception {
		OcrReader.translationVector = new Vector<String>();
	}

	@After
	public void tearDown() throws Exception {
	}

	public void test_OcrFileExists(){

		String inputFile = "ocr.txt";
		Assert.assertNotNull(OcrReader.parseFile(inputFile));

	}
	
	public void test_OcrDictionaryTranslateOneLineUsingDictionary(){
		
		String inputPattern = "    _  _  _     _  _     _ ";
		Vector<String> expectedOutput = new Vector<String>();
		expectedOutput.add("1");
		expectedOutput.add("2");
		expectedOutput.add("2");
		expectedOutput.add("2");
		expectedOutput.add("1");
		expectedOutput.add("2");
		expectedOutput.add("2");
		expectedOutput.add("1");
		expectedOutput.add("2");
		OcrReader.translateStringPatterToVector(inputPattern);
		Assert.assertEquals(expectedOutput, OcrReader.translationVector);		
	
	}
	
	public void test_retrieveAccountFromTranslatedFileUsingDictionary(){
		Vector<String> inputVector = new Vector<String>();
		int expectedValue = 123456789;
		inputVector.add("133");
		inputVector.add("246");
		inputVector.add("244");
		inputVector.add("153");
		inputVector.add("264");
		inputVector.add("265");
		inputVector.add("233");
		inputVector.add("255");
		inputVector.add("254");
		Assert.assertEquals(expectedValue, OcrReader.translateVectorToAccountNumber(inputVector));
		
		
		
	}
	
	

	public void test_OcrRead111111111(){

		String inputFile = "ocr11111111.txt";
		int expectedValue = 111111111;
		Assert.assertEquals(expectedValue, OcrReader.getOcrCode(inputFile));

	}

	public void test_OcrRead222222222(){

		String inputFile = "ocr222222222.txt";
		int expectedValue = 222222222;
		Assert.assertEquals(expectedValue, OcrReader.getOcrCode(inputFile));

	}
	
	public void test_OcrRead123456789(){

		String inputFile = "ocr.txt";
		int expectedValue = 123456789;
		Assert.assertEquals(expectedValue, OcrReader.getOcrCode(inputFile));

	}


}
