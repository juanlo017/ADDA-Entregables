package Tests;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import Ejercicios.ejercicio1;

public class Test1 {
	
	public static void main(String[] args) {
		List<List<String>> file = ejercicio1.leeFichero(".\\ficheros\\PI1E1_DatosEntrada.txt");
		test1(file);
		
		//System.out.println(ejercicio1.iterativo(file));
	}

	private static void test1(List<List<String>> file) {
		
		Predicate<String> pS = x -> (x.contains("a")||x.contains("e")||x.contains("o"));
		Function<String, Integer> f = x -> x.length();
		Predicate<Integer> pI = x -> (x % 2 == 0);
		
		for(List<String> i : file) {
			System.out.println( "Entrada: " + i + "\n" + 
			"Iterativo: " + ejercicio1.iterativo(i) + "\n" +
			"Recursivo: " + ejercicio1.recursivo(i, 0, false) + "\n" +
			"Funcional: " + ejercicio1.funcional(i, pS, pI, f));
		}
	}
}
