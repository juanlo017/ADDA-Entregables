package Tests;

import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.Tree;

import java.util.function.Predicate;

import Ejercicios.Ejercicio1;

public class Test1 {

	public static void main(String[] args) {
		Predicate<Integer> esPar = x -> x%2 == 0;
		Predicate<Integer> menorQueCinco = x -> x<5;
		System.out.println("RECURSIVA-PAR");
		Files2.linesFromFile(".\\ficheros\\PI3E1_DatosEntrada.txt").forEach(linea -> testRecursivo(linea, esPar));
		System.out.println("RECURSIVA-MENOR-QUE-5");
		Files2.linesFromFile(".\\ficheros\\PI3E1_DatosEntrada.txt").forEach(linea -> testRecursivo(linea, menorQueCinco));
		System.out.println("FUNCIONAL-PAR");
		Files2.linesFromFile(".\\ficheros\\PI3E1_DatosEntrada.txt").forEach(linea -> testFuncional(linea, esPar));
		System.out.println("FUNCIONAL-MENOR-QUE-5");
		Files2.linesFromFile(".\\ficheros\\PI3E1_DatosEntrada.txt").forEach(linea -> testFuncional(linea, menorQueCinco));
	}
	
	
	private static void testRecursivo(String linea, Predicate<Integer> p) {
		Tree<Integer> tree = Tree.parse(linea, x -> Integer.parseInt(x)); //parsear cada linea a un Tree
		System.out.println(
				String.format("%s: ", linea) + Ejercicio1.recursivo(tree, p));
	}
	
	private static void testFuncional(String linea, Predicate<Integer> p) {
		Tree<Integer> tree = Tree.parse(linea, x -> Integer.parseInt(x)); //parsear cada linea a un Tree
		System.out.println(
				String.format("%s: ", linea) + Ejercicio1.recursivoFuncional(tree, p));
	}
	
}
