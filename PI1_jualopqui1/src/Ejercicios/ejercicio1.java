package Ejercicios;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.stream.Collectors;
//import us.lsi.common.Files2;
//import us.lsi.iterables.Iterables;



public class ejercicio1 {	
	
	//El predicado sobre String devuelve cierto si dicho String contiene alguna vocal abierta (es decir, a, e ó o)
	//La función String -> Integer devuelve la longitud de la cadena 
	//El predicado sobre Integer devuelve cierto si ese entero es par
	//iterativa
	public static boolean iterativo (List<String> ls, Predicate<String> pS,
			Predicate<Integer> pI, Function<String, Integer> f){
		
		boolean b = false;
		Integer i = 0;
		while (i < ls.size()) {
			String word = ls.get(i);
			// pf.test()
			Integer e = f.apply(word);
			if((pS.test(word)) && (pI.test(e))) {
					b = true;
					break;
				}
			i++;
			}
			
		return b;
	}
	
	//recursiva final
	public static boolean recursivo (List<String> ls, Predicate<String> pS,
			Predicate<Integer> pI, Function<String, Integer> f) {
		//cuando res==true no ejecuta el if y lo retorna (reemplaza al break del iterativo)
		Integer i = 0;
		boolean b = false;
		return recursivo(ls, pS, pI, f, i, b);
	}
	
	public static boolean recursivo (List<String> ls, Predicate<String> pS,
			Predicate<Integer> pI, Function<String, Integer> f, Integer i, boolean b) {
		//cuando b==true no ejecuta el if y lo retorna (reemplaza al break del iterativo)
		if(i < ls.size() && !b) {
			String word = ls.get(i);
			// pf.test()
			Integer e = f.apply(word);
			//System.out.println(i + " : " + word + " tiene longitud " + e);
			if((pS.test(word)) && (pI.test(e))) {
					b = true;
				}
			//System.out.println(" b en la siguiente iteracion vale: " + b);
			i++;
			b = recursivo(ls, pS, pI, f, i, b);
		}
		return b;	
	}
	
	
	//funcional
	
	public static boolean funcional (List<String> ls, Predicate<String> pS,
			Predicate<Integer> pI, Function<String, Integer> f) {
		return ls.stream()
				.filter(pS)
				.map(f)
				.anyMatch(pI);
	}
	
	
//leer fichero
//	public static List<List<String>> leeFichero (String file){
//		List<List<String>> res = new ArrayList<>();
//		Iterator<String> fileIt = Iterables.file(file).iterator();
//		//iterate over every line
//		while(fileIt.hasNext()) {
//			String line = fileIt.next();
//			List<String> lineWordList = new ArrayList<>();
//			Iterator<String> lineIt = Iterables.split(line, "[ ,]").iterator();
//			//iterate over every element in the line
//			while(lineIt.hasNext()) {
//				lineWordList.add(lineIt.next());
//			}
//			res.add(lineWordList);
//		}
//		return res;
//	}
}
