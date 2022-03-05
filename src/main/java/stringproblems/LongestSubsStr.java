package stringproblems;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class LongestSubsStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s = "abcdedbjfdlk";
		String s = "123454276498";
		LongestSubsStr obj = new LongestSubsStr();
		System.out.println(obj.lengthOfLongestSubstringV2(s));
	}

	public void printMap(HashMap<Character, Integer> map){
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			System.out.println(entry.getKey() +  ": " + entry.getValue() );
		}		
	}

	//Ref: https://www.youtube.com/watch?v=3IETreEybaA&ab_channel=NickWhite
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.isEmpty())
			return 0;
		int start = 0;
		int end = 0;
		int max = 0;
		Set<Character> set = new HashSet<>();
		while(end< s.length()){
			if(!set.contains(s.charAt(end))){
				set.add(s.charAt(end));
				end++;
				max = Math.max(set.size(), max);
			}else{
				System.out.println("removing: " + start + "th," +  s.charAt(start));
				set.remove(s.charAt(start));
				start++;
			}
			System.out.println("Start:" + start + " | end:" + end + " | set size: " + set.size());
		}       
		return max;
	}

	
	public int lengthOfLongestSubstringV0(String s) {
		int n = s.length(); 
		int max  = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int end = 0, start = 0; end < n; end++) {
			
			Character endChar = s.charAt(end);
			if (map.containsKey(endChar)) {
				start = Math.max(map.get(endChar), start);
			}
			max = Math.max(max, end - start + 1);
			map.put(endChar, end + 1);
		}
		return max;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	public int lengthOfLongestSubstringV2(String s) {
		//Start with zero because charAt convention start from zero
		int start = 0;
		int length = s.length();
		if(length<1)
			return 0;
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int end = 0; end< length; end++){
			Character endChar = s.charAt(end);
			if(map.containsKey(endChar)){
				start = Math.max(start, map.get(endChar));
			}
			max = Math.max(max, end - start + 1);
			map.put(endChar, end + 1);
			
		}
		
		return max;
	}


	@Test
	public void validate() {
		assertEquals("".length(), lengthOfLongestSubstringV2(""));
		assertEquals("A".length(), lengthOfLongestSubstringV2("A"));
		assertEquals("ABCDEF".length(), lengthOfLongestSubstringV2("AABCDEF"));
		assertEquals("ABCDEF".length(), lengthOfLongestSubstringV2("ABCDEFF"));
		assertEquals("NGISAWE".length(), lengthOfLongestSubstringV2("CODINGISAWESOME"));
		assertEquals("be coding".length(), lengthOfLongestSubstringV2("always be coding"));
	}

}

