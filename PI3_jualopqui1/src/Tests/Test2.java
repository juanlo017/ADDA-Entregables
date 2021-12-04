package Tests;

import java.util.List;

import Ejercicios.Ejercicio2;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class Test2 {

	public static void main(String[] args) {
		Files2.linesFromFile(".\\ficheros\\PI3E2_DatosEntrada.txt").forEach(linea -> test(linea));
	}

	private static void test(String linea) {
		String[] trozos = linea.split("#");
		BinaryTree<Integer> tree = BinaryTree.parse(trozos[0], x -> Integer.parseInt(x));
		Integer n = Integer.parseInt(trozos[1]);
		System.out.println(trozos[0] + ": " + Ejercicio2.recursivo(tree, n));
	}
}
