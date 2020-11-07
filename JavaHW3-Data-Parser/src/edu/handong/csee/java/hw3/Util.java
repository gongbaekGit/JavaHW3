package edu.handong.csee.java.hw3;

/**
 * this class contain static methods that dealing string.
 * @return
 */
public class Util {
	
	static int startIndex;
	static int endIndex;

	public static int findKeyWords(String originStr, String key) {
		//키워드가 존재하는 인덱스의 시작값을 startIndex에 저장한다.
		startIndex = originStr.indexOf(key + "\"");
		return startIndex;
	}
	
	public static void getValue(String originStr, String key) {
		// 키워드가 담고있는 값이 끝나는 인덱스를 startIndex에 저장한다.
		//일단 value가 object인 경우는 생각하지 않는다.
		//+4를 +3으로 바꾸면 value 앞의 공백이 포함된다.
		String tempStr = originStr.substring(startIndex + key.length()+4);
		//+0을 +1로 바꾸면 개행까지 완료가 됩니다.
		endIndex = tempStr.indexOf('\n') + startIndex + key.length()+4 +1;
		
		//Parser 클래스의 value 변수에 값을 할당한다.
		Parser.value = originStr.substring(startIndex + key.length() + 4, endIndex);
		System.out.print(Parser.value);
	}
	
	public static void makeNewstr(String originStr){
	//Parser 클래스의 newStr에 새로운 문장, 다음 탐색 대상인 문장을 저장한다.
	//앞에서 개행문자를 포함했기 때문에 + 0 입니다.
	Parser.str = originStr.substring(endIndex + Parser.value.length()-4);
	//System.out.print("\n다음 탐색 대상 문장을 만들었습니다. \n" + Parser.str);	
	}
}







