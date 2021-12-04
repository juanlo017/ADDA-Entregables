package Tests;

import java.util.List;

import Ejercicios.Ejercicio4;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.Tree;

public class Test4 {

	public static void main(String[] args) {
		Files2.linesFromFile(".\\ficheros\\PI3E4_DatosEntrada.txt").forEach(linea -> test(linea));	
	}
	
	private static void test(String linea) {
		Tree<String> tree = Tree.parse(linea);
		System.out.println(linea + ": " + Ejercicio4.recursivo(tree));
	}

}
