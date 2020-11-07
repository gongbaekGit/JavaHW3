package edu.handong.csee.java.hw3;

public class Parser {
	
	private String key;
	public static String str;
	public static String newstr;
	public static String value;
	
	public Parser(String korData, String keyWords) {
		str = korData;
		key = keyWords;
		System.out.print("key words is " + key + "\n");
	}
	
	public String getKey() {
		return key;
	}
	
	public void parseOne() {
		Util.findKeyWords(str, key);
		Util.getValue(str, key);
		Util.makeNewstr(str);
		/*
		Util.findKeyWords(str, key);
		Util.getValue(str, key);
		Util.makeNewstr(str);
		*/
	}
}
