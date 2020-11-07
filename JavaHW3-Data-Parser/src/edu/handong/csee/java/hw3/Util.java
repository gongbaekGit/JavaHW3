package edu.handong.csee.java.hw3;

/**
 * this class contain static methods that treat JSON strings.
 * @author bangseungmin
 *
 */
public class Util {
	/*
	 * this fields made to contain the start index  where value of property.
	 */
	static int startIndex;
	/*
	 * This fields made to contain the end ndex of the value.
	 */
	static int endIndex;

	/**
	 * findKeyWords contain logic fpr start index of property
	 * @param originStr : origin string what we searched
	 * @param key : key words what we searching for.
	 * @return : index num where key words start.
	 */
	public static int findKeyWords(String originStr, String key) {
		//키워드가 존재하는 인덱스의 시작값을 startIndex에 저장한다.
		startIndex = originStr.indexOf(key + "\"");
		return startIndex;
	}
	
	/**
	 * getValue methods contain logic for make value-contain-string.
	 * the founded value will store in Parser.value.
	 * if the value is object {} or arry[], call Util.treatObject(). 
	 * @param originStr : origin string what we searched
	 * @param key : key words what we searching for.
	 */
	public static void getValue(String originStr, String key) {
		// 키워드가 담고있는 값이 끝나는 인덱스를 startIndex에 저장한다.
		if(originStr.charAt(startIndex + key.length() + 4 ) == '[' || originStr.charAt(startIndex + key.length() + 4 ) == '{') {
			treatObject(originStr, key);
		}
		else {
			//+4를 +3으로 바꾸면 value 앞의 공백이 포함된다.
			String tempStr = originStr.substring(startIndex + key.length()+4);
			//+0을 +1로 바꾸면 개행까지 완료가 됩니다.
			endIndex = tempStr.indexOf('\n') + startIndex + key.length()+4 +1;
		}
		
		//Parser 클래스의 value 변수에 값을 할당한다.
		Parser.setValue(originStr.substring(startIndex + key.length() + 4, endIndex)); 
		System.out.print(Parser.getValue());
	}
	
	/**
	 * This methods make new string.
	 * new string have text that we have not searched.
	 * new string doesn't have text that we search already.
	 * @param originStr :  origin string what we searched
	 * @param key : key words what we searching for.
	 */
	public static void makeNewstr(String originStr, String key){
	//Parser 클래스의 newStr에 새로운 문장, 다음 탐색 대상인 문장을 저장한다.
	//앞에서 개행문자를 포함했기 때문에 + 0 입니다.
	Parser.setStr(originStr.substring(startIndex + key.length()+4));
	}
	
	/**
	 * This methods made to treat object or array type value of JSON.
	 * find endIndex of value according to indentation.
	 * @param originStr :  origin string what we searched
	 * @param key : key words what we searching for.
	 */
	public static void treatObject(String originStr, String key) {
		int i = 1;
		String blankStr = "\"";
		
		
		//property의 indent 정도를 파악한다.
		while((" "+blankStr).equals(originStr.substring(startIndex-1-i, startIndex))) {
			
			blankStr = " " + blankStr;
			i++;		
		}
		
		i--;
		
		
		//property의 indent에 해당하는 공백 + } 또는 ]을 반환한다.
		String bl = "";
		for(; i>0;i--) bl = bl + " ";
		
		
		switch(originStr.charAt(startIndex + key.length() + 4 )) {
			case '[' :
				bl = bl + "]";
				break;
			case  '{' :
				bl = bl + "}";
				break;
		}
		
		
		String tempStr = originStr.substring(startIndex + key.length()+4);
		//+0을 +1로 바꾸면 개행까지 완료가 됩니다.	
		endIndex = tempStr.indexOf("\n" + bl) + startIndex + key.length() +4 + bl.length() +2;
		
	}
}







