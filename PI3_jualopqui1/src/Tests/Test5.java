package Tests;

import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;
import Ejercicios.Ejercicio5;

public class Test5 {

	public static void main(String[] args) {
		System.out.println("RECURSIVA: \n");
		Files2.linesFromFile(".\\ficheros\\PI3E5_DatosEntrada.txt").forEach(linea -> testRecursivo(linea));
		System.out.println("FUNCIONAL: \n");
		//Files2.linesFromFile(".\\ficheros\\PI3E5_DatosEntrada.txt").forEach(linea -> testFuncional(linea));
	}
	
	private static void testRecursivo(String linea) {
		BinaryTree<Integer> tree = BinaryTree.parse(linea, x -> Integer.parseInt(x));
		System.out.println(linea + ": " + Ejercicio5.recursiva(tree));
	}
	
	private static void testFuncional(String linea) {
		BinaryTree<Integer> tree = BinaryTree.parse(linea, x -> Integer.parseInt(x));
		System.out.println(linea + ": " + Ejercicio5.funcional(tree));;
	}

	
}
