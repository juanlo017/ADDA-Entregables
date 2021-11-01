package Tests;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import Ejercicios.Ejercicio1;
import Ejercicios.Ejercicio2;
import Ejercicios.Ejercicio3;
import Ejercicios.Ejercicio5;
import us.lsi.common.Files2;
import us.lsi.common.Matrix;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> file1 = leeFichero(".\\ficheros\\PI2Ej1DatosEntrada.txt");
		//test1(file1);
		List<List<String>> file2 = leeFicheroEjercicio2(".\\ficheros\\PI2Ej2DatosEntrada2.txt");
		//test2(file2);
		List<List<String>> file3 = leeFicheroEjercicio3(".\\ficheros\\PI2Ej3DatosEntrada.txt");
		//test3(file3);
		List<List<String>> file4 = leeFicheroEjercicio4(".\\ficheros\\PI2Ej4DatosEntrada.txt");
		//test4(file4);
		List<List<String>> file5 = leeFichero(".\\ficheros\\PI2Ej5DatosEntrada.txt");
		test5(file5);
	}
	
	private static void test1(List<List<String>> file) {
		for(List<String> i : file) {
			Integer a = Integer.valueOf(i.get(0));
			Integer b = Integer.valueOf(i.get(1));
			Integer c = Integer.valueOf(i.get(2));
			System.out.println( "Entrada: " + i + "\n" + 
						"Iterativo: " + Ejercicio1.iterativo(a, b, c) + "\n" +
						"Recursivo no final: " + Ejercicio1.recursivoNoFinal(a, b, c)+ "\n" +
						"Recursivo final: " + Ejercicio1.recursivoFinal(a, b, c) + "\n" +
						"Funcional: " + "\n");
		}
	}
	
	private static void test2(List<List<String>> file) {
		List<String> ls = Ejercicio2.recursivo(file);
		for(String i : ls) {
			System.out.println(String.format("%s \n", i));
		}
	}
	
	private static void test3(List<List<String>> file) {
		for(List<String> i : file) {
			Integer b = Integer.valueOf(i.get(i.size()-1));
			i.remove(i.size()-1);
			Integer a = Integer.valueOf(i.get(i.size()-1));
			i.remove(i.size()-1);
			
			List<Integer> ls = i.stream().map(x-> Integer.valueOf(x)).collect(Collectors.toList());
			
			System.out.println("Entrada: " + i + "\n" +
					"Rango: " + a + "-" + b + "\n" +
					"Conjunto Obtenido: " + Ejercicio3.recursivo(ls, a, b) + "\n" +
						"____________________________________________" + "\n");	
		}
	}
	
	private static void test4(List<List<String>> file) {
		for (List<String> i : file) {
			Integer n = Integer.valueOf(i.get(1));
			System.out.println(n);
		}
	}
	
	private static void test5(List<List<String>> file) {
		for(List<String> i : file) {
			Integer a = Integer.valueOf(i.get(0));
			Integer b = Integer.valueOf(i.get(1));
			Integer c = Integer.valueOf(i.get(2));
			System.out.println(String.format("(a, b, c) = (%s,%s,%s)",a,b,c));
			System.out.println(
					"Recursivo sin memoria: " +
					Ejercicio5.recursivoSinMemoria(a, b, c) + "\n" +
					"Recursivo con memoria: " +
					Ejercicio5.recursivoConMemoria(a, b, c) + "\n" +
					"_______________________________________");
		}
	}

	
	
	
	//read file 1 exercise
	private static List<List<String>> leeFichero(String file){
		return Files2.streamFromFile(file).map(f).collect(Collectors.toList());
	}
	private static Function<String, List<String>> f = x -> Arrays.stream(x.split(",")).collect(Collectors.toList());
	//read file 2 exercise
	private static List<List<String>> leeFicheroEjercicio2(String file){
		return Files2.streamFromFile(file).map(h).collect(Collectors.toList());
	}
	private static Function<String, List<String>> h = x -> Arrays.stream(x.split(" ")).collect(Collectors.toList());
	//read file 3 exercise
	private static List<List<String>> leeFicheroEjercicio3(String file){
		return Files2.streamFromFile(file).map(t).collect(Collectors.toList());
	}
	private static Function<String, List<String>> t = x -> Arrays.stream(x.split(",|#")).collect(Collectors.toList());
	//read file 4 exercise
	private static List<List<String>> leeFicheroEjercicio4(String file){
		return Files2.streamFromFile(file).map(g).collect(Collectors.toList());
	}
	private static Function<String, List<String>> g = x -> Arrays.stream(x.split("=")).collect(Collectors.toList());
	
	
	
}
