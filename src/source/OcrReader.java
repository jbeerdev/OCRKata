package source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class OcrReader {

	private static final int CHAR_LENGHT = 3;
	public static Vector<String> translationVector = new Vector<String>();

	public static int getOcrCode(String inputFile) {
		BufferedReader buffReader = parseFile(inputFile);
		int counter = 3;
		while(counter!=0) {
			String line = null;
			try {
				line = buffReader.readLine();
				translateStringPatterToVector(line);
			} catch (IOException e) {
				e.printStackTrace();
			} 
			counter--;

		} 	
		return translateVectorToAccountNumber(translationVector);
	}

	public static BufferedReader parseFile(String inputFile) {
		File ocrFile = new File(inputFile);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(ocrFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return bufferReader;
	}

	public static void translateStringPatterToVector(String inputPattern) {

		int counter = 0;
		for(int i=0;i<9;i++){
			if(translationVector.size()!=i){
				translationVector.set(i,translationVector.get(i)+OcrDictionary.ocrDictionary.get(inputPattern.substring(counter,counter + CHAR_LENGHT)));
			}else{
				translationVector.add(String.valueOf(OcrDictionary.ocrDictionary.get(inputPattern.substring(counter,counter + CHAR_LENGHT))));
			}
			counter = counter +CHAR_LENGHT;
		}
	}

	public static int translateVectorToAccountNumber(Vector<String> inputVector) {
		String accountNumber = "0";
		for(int i=0;i<inputVector.size();i++){
			accountNumber = accountNumber + OcrDictionary.numericTranslator.get(inputVector.get(i));
		}		
		return Integer.valueOf(accountNumber);
	}




}


