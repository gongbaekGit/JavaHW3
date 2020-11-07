package edu.handong.csee.java.hw3;

public class Parser {
	
	private String key;
	private static String str;
	private static String value;
	
	public static String getStr() {
		return str;
	}

	public static void setStr(String str) {
		Parser.str = str;
	}

	public static String getValue() {
		return value;
	}

	public static void setValue(String value) {
		Parser.value = value;
	}

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
		
		/**
		 * loop when there is key words Json string.
		 */
		while(Util.findKeyWords(str, key)>=0) {
			Util.getValue(str, key);
			Util.makeNewstr(str, key);
		}
	}
}
