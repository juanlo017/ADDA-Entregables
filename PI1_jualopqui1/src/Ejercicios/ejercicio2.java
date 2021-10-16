package Ejercicios;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ejercicio2 {
	//iterativo
	public static Map<Integer, List<String>> iterativo (List<List<String>>ls){
		Map<Integer, List<String>> res = new HashMap<>();
		Integer i = 0;
		while(i < ls.size()) {
			List<String> currentList = ls.get(i);
			Integer e = 0;
			while(e < currentList.size()) {
				String currentWord = currentList.get(e);
				if(res.containsKey(currentWord.length())){
					res.get(currentWord.length()).add(currentWord);
				}else {
					List<String> wordList = new ArrayList<>();
					wordList.add(currentWord);
					res.put(currentWord.length(), wordList);
				}
				e++;
			}
			i++;
		}
		return res;
	}
	//recursivo
	public static Map<Integer, List<String>> recursivo (List<List<String>> ls){
		Map<Integer, List<String>> m = new HashMap<>();
		Integer i = 0;
		return recursivo(ls, i, m);
	}
	
	public static Map<Integer, List<String>> recursivo (List<List<String>> ls, Integer i,Map<Integer, List<String>> m){
		if(i < ls.size()) {
			Integer e = 0;
			List<String> currentList = ls.get(i);
			while(e < currentList.size()) {
				String currentWord = currentList.get(e);
				if(m.containsKey(currentWord.length())){
					m.get(currentWord.length()).add(currentWord);
				}else {
					List<String> wordList = new ArrayList<>();
					wordList.add(currentWord);
					m.put(currentWord.length(), wordList);
				}
				e++;
			}
			i++;
			recursivo(ls, i, m);
		}
		return m;
	}
	
	
	//funcional
	public static Map<Integer, List<String>> funcional (List<List<String>> ls){
		return ls.stream()
				.flatMap(x -> x.stream())
				.collect(Collectors.groupingBy(String::length));
	}
}
