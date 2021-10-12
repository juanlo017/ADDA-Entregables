package Ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import us.lsi.iterables.Iterables;

//El predicado sobre String devuelve cierto si dicho String contiene alguna vocal abierta (es decir, a, e ó o)
//La función String -> Integer devuelve la longitud de la cadena 
//El predicado sobre Integer devuelve cierto si ese entero es par

public class ejercicio1 {	
	
	//leer fichero
	public static List<List<String>> leeFichero (String file){
		List<List<String>> res = new ArrayList<>();
		Iterator<String> fileIt = Iterables.file(file).iterator();
		//iterate over every line
		while(fileIt.hasNext()) {
			String line = fileIt.next();
			List<String> lineWordList = new ArrayList<>();
			Iterator<String> lineIt = Iterables.split(line, "[ ,]").iterator();
			//iterate over every element in the line
			while(lineIt.hasNext()) {
				lineWordList.add(lineIt.next());
			}
			res.add(lineWordList);
		}
		return res;
	}
	
	//iterativa
	public static boolean iterativo (List<String> ls){
		boolean res = false;
		Integer i = 0;
		while (i < ls.size()) {
			String word = ls.get(i);
			if((word.contains("a")||word.contains("e")||word.contains("o")) && (word.length() % 2 == 0)) {
					res = true;
					break;
				}
			i++;
			}
			
		return res;
	}
	
	//recursiva final
	public static boolean recursivo (List<String> ls, Integer i, boolean res) {
		//cuando res==true no ejecuta el if y lo retorna (reemplaza al break del iterativo)
		if(i < ls.size() && !res) {
			String word = ls.get(i);
			if((word.contains("a")||word.contains("e")||word.contains("o")) && (word.length() % 2 == 0)) {
				res = true;
			}
			i++;
			res = recursivo(ls, i, res);
		}
		return res;	
	}
			
	
	
	//funcional
	
	public static boolean funcional (List<String> ls, Predicate<String> pS,
			Predicate<Integer> pI, Function<String, Integer> f) {
		return ls.stream()
				.filter(pS)
				.map(f)
				.anyMatch(pI);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
