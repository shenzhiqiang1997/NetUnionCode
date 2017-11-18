package priv.shen.daily.q1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class StringType {
	public static void main(String[] args) {
		int num;
		String[] strings;
		int[] hasType;
		
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("输入整数N:");
		num=scanner.nextInt();
		
		strings=new String[num];
		hasType=new int[num];
		for (int i = 0; i < hasType.length; i++) {
			hasType[i]=-1;
		}
		
		System.out.println("输入N个字符串:");
		
		for (int i = 0; i < strings.length; i++) {
			strings[i]=scanner.next();
		}
		
		for (int i = 0; i < strings.length; i++) {
			String s1=strings[i];
			
			if(hasType[i]==-1) {
				hasType[i]=i;
			}
			for (int j = i+1; j <strings.length ; j++) {
				if(hasType[j]>=0) {
					continue;
				}else {
					String s2=strings[j];
					if(typeEquals(s1, s2)) {
						hasType[j]=i;
					}
				}
			}
		}
		
		Set<Integer> typeCount=new HashSet<>();
		
		for (int i = 0; i < hasType.length; i++) {
			if(!typeCount.contains(hasType[i])) {
				typeCount.add(hasType[i]);
			}
		}
		
		System.out.println(typeCount.size());
		
		scanner.close();
	}
	public static boolean typeEquals(String s1,String s2) {
		
		
		if(s1.length()==s2.length()) {
			char[] chars1=s1.toCharArray();
			char[] chars2=s1.toCharArray();
			
			HashMap<Character, Integer> charTimes1=countCharTimes(chars1);
			HashMap<Character, Integer> charTimes2=countCharTimes(chars2);
			
			
			if(charTimes1.size()==charTimes2.size()) {
				Set<Entry<Character, Integer>> entrys1=charTimes1.entrySet();
				
				for (Entry<Character, Integer> entry : entrys1) {
					Character key=entry.getKey();
					
					if(charTimes2.containsKey(key)) {
						Integer times=entry.getValue();
						if(!times.equals(charTimes2.get(key))) {
							return false;
						}
					}else {
						return false;
					}
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
		
		return true;
	}
	public static HashMap<Character, Integer> countCharTimes(char[] chars) {
		HashMap<Character, Integer> charTimes=new HashMap<>();
		
		for (int i = 0; i < chars.length; i++) {
			char ch=chars[i];
			
			if(charTimes.containsKey(ch)) {
				charTimes.put(ch, charTimes.get(ch)+1);
			}else {
				charTimes.put(ch, 1);
			}
		}
		
		return charTimes;
	}
}
