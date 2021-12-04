package Tests;

import Ejercicios.Ejercicio3;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;

public class Test3 {

	public static void main(String[] args) {
		
		System.out.println("SOLUCION RECURSIVA: \n ");
		Files2.linesFromFile(".\\ficheros\\PI3E3_DatosEntrada.txt").forEach(linea -> test(linea));		
	}

	private static void test(String linea) {
		BinaryTree<Integer> tree = BinaryTree.parse(linea, x -> Integer.parseInt(x));
		System.out.println(tree + ": " + Ejercicio3.recursivo(tree));
	}
}
