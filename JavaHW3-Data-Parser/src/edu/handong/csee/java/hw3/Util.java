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
		
		/*
		//일단 value가 object인 경우는 생각하지 않는다.
		//+4를 +3으로 바꾸면 value 앞의 공백이 포함된다.
		String tempStr = originStr.substring(startIndex + key.length()+4);
		//+0을 +1로 바꾸면 개행까지 완료가 됩니다.
		endIndex = tempStr.indexOf('\n') + startIndex + key.length()+4 +1;
		*/
		
		
		//object나 배열일 경우를 다룬다.
		if(originStr.charAt(startIndex + key.length() + 4 ) == '[' || originStr.charAt(startIndex + key.length() + 4 ) == '{') {
			treatObject(originStr, key);
			//System.out.print("\n요기요2222222\n");
		}
		else {
			//+4를 +3으로 바꾸면 value 앞의 공백이 포함된다.
			String tempStr = originStr.substring(startIndex + key.length()+4);
			//+0을 +1로 바꾸면 개행까지 완료가 됩니다.
			endIndex = tempStr.indexOf('\n') + startIndex + key.length()+4 +1;
		}
		
		
		//Parser 클래스의 value 변수에 값을 할당한다.
		Parser.value = originStr.substring(startIndex + key.length() + 4, endIndex);
		System.out.print(Parser.value);
	}
	
	public static void makeNewstr(String originStr, String key){
	//Parser 클래스의 newStr에 새로운 문장, 다음 탐색 대상인 문장을 저장한다.
	//앞에서 개행문자를 포함했기 때문에 + 0 입니다.
	Parser.str = originStr.substring(startIndex + key.length()+4);
	//System.out.print("\n다음 탐색 대상 문장을 만들었습니다. \n" + Parser.str);	
	}
	
	
	
	public static void treatObject(String originStr, String key) {
		int i = 1;
		String blankStr = "\"";
		
		
		//property의 indent 정도를 파악한다.
		while((" "+blankStr).equals(originStr.substring(startIndex-1-i, startIndex))) {
			//System.out.print("\n\n공백" + originStr.substring(startIndex-1-i, startIndex));
			//System.out.print("\n공백"+ " " + blankStr +"\n");
			
			blankStr = " " + blankStr;
			i++;		
		}
		
		i--;
		/*
		System.out.print("\n요기요2\n");
		System.out.print("\n\n공백체" + originStr.substring(startIndex-1-i, startIndex));
		System.out.print("\n공백체"+ blankStr +"\n");
		*/
		
		
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
		
		//여기까지는 확실함
		//System.out.print("\n토큰은\n" + bl + "\n\n\n");

		String tempStr = originStr.substring(startIndex + key.length()+4);
		//+0을 +1로 바꾸면 개행까지 완료가 됩니다.
		
		
		//출력할때는 이게 맞음.
		//endIndex = tempStr.indexOf(bl) + bl.length() + startIndex + key.length()+4 +1;
		
		endIndex = tempStr.indexOf("\n" + bl) + startIndex + key.length() +4 + bl.length() +2;
		//System.out.print("\n\n인덱스 앞의 값:" + originStr.charAt(endIndex-1)  + "ㅇ\n\n\n");
		
		
		
		//System.out.print("\n\n시작은 이러하다\n\n" + originStr.substring(endIndex));
	}
}







