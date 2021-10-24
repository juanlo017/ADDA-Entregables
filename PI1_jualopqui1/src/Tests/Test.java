package Tests;

import us.lsi.common.Files2;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import Ejercicios.ejercicio1;
import Ejercicios.ejercicio2;
import Ejercicios.ejercicio3;
import Ejercicios.ejercicio4;





public class Test {
	
	public static void main(String[] args) {
		System.out.println("EJERCICIO 1");
		List<List<String>> fileTest1 = leeFichero(".\\ficheros\\PI1E1_DatosEntrada.txt");
		//test1(fileTest1);	
		System.out.println("EJERCICIO 2");
		List<List<String>> fileTest2 = leeFichero(".\\ficheros\\PI1E2_DatosEntrada1.txt");
		//test2(fileTest2);
		System.out.println("EJERCICIO 3");
		List<List<String>> fileTest3 = leeFichero(".\\ficheros\\PI1E3_DatosEntrada.txt");
		//test3(fileTest3);
		System.out.println("EJERCICIO 4");
		List<List<String>> fileTest4 = leeFichero(".\\ficheros\\PI1E4_DatosEntrada.txt");
		System.out.println(fileTest4);
		test4(fileTest4);
		
	}
	
	
	public static List<List<String>> leeFichero(String file){
		return Files2.streamFromFile(file).map(f).collect(Collectors.toList());
	}
	public static Function<String, List<String>> f = x -> Arrays.stream(x.split(",")).collect(Collectors.toList());
	
	

	private static void test1(List<List<String>> file) {
		
		Predicate<String> pS = x -> (x.contains("a")||x.contains("e")||x.contains("o"));
		Function<String, Integer> f = x -> x.length();
		Predicate<Integer> pI = x -> (x % 2 == 0);
		
		for(List<String> ls : file) {
			System.out.println( "Entrada: " + ls + "\n" + 
			"Iterativo: " + ejercicio1.iterativo(ls, pS, pI, f) + "\n" +
			"Recursivo: " + ejercicio1.recursivo(ls, pS, pI, f)+ "\n" +
			"Funcional: " + ejercicio1.funcional(ls, pS, pI, f));
		}
	}
	
	
	private static void test2(List<List<String>> file) {
		System.out.println( "Entrada: " + file + "\n" + 
			"Iterativo: " + ejercicio2.iterativo(file) + "\n" +
			"Recursivo: " + ejercicio2.recursivo(file)+ "\n" +
			"Funcional: " + ejercicio2.funcional(file));		
	}
	
	
	private static void test3(List<List<String>> file) {
		
		for(List<String> ls : file) {
			
			Integer a = Integer.valueOf(ls.get(0));
			Integer limit = Integer.valueOf(ls.get(1));
			
			System.out.println( "Entrada: " + a + ", " + limit + "\n" + 
					"Iterativa: " + ejercicio3.iterativo(a, limit) + "\n" +
					"Recursiva:" + ejercicio3.recursivo(a, limit) + "\n" +
					"Funcional: " + ejercicio3.funcional(a, limit));
		}
	}
	
	
	
	private static void test4(List<List<String>> file) {
		// TODO Auto-generated method stub
		for(List<String> ls : file) {
			
			Double n = Double.valueOf(ls.get(0));
			Double e = Double.valueOf(ls.get(1));
			
			System.out.println( "Raiz cubica de: " + n + " con error menor que: " + e + "\n" + 
					"Iterativa: " + ejercicio4.iterativo(n, e) + "\n" +
					"Recursiva:" + ejercicio4.recursivo(n, e) + "\n" +
				    "Funcional: " + ejercicio4.funcional(n, e));
		}
	}
	
	
}
