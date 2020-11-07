package edu.handong.csee.java.hw3;

public class Parser {
	
	private String key;
	public static String str;
	public static String newstr;
	public static String value;
	
	public Parser(String korData, String keyWords) {
		str = korData;
		key = keyWords;
		System.out.print("key words is " + key + "\nbelow it the value of property : " + key + "\n");
		System.out.print("------------------------------------------------------\n");
	}
	
	public String getKey() {
		return key;
	}
	
	public void parseOne() {
		
		
		while(Util.findKeyWords(str, key)>=0) {
			Util.getValue(str, key);
			Util.makeNewstr(str, key);
		}
		
		
		
		
		/*
		//한 번 찾는데 필요한 로직
		
		Util.findKeyWords(str, key);
		Util.getValue(str, key);
		Util.makeNewstr(str, key);
		*/
	}
}
