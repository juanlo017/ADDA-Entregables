package Ejercicios;

import java.util.HashSet;
import java.util.Set;

import us.lsi.tiposrecursivos.BinaryTree;


public class Ejercicio2 {
	
	public static Set<Integer> recursivo(BinaryTree<Integer> tree, Integer n){
		return recursivo(tree, n, new HashSet<>());
	}

	private static Set<Integer> recursivo(BinaryTree<Integer> tree, Integer n, Set<Integer> conjunto) {
		switch(tree.getType()) {
		case Empty:
			break;
		case Leaf:
			if (tree.getLabel() >= n) conjunto.add(tree.getLabel());
			break;
		case Binary:
			if (tree.getLabel() >= n) {
				conjunto.add(tree.getLabel()); 
				recursivo(tree.getLeft(), n, conjunto);
				recursivo(tree.getRight(), n, conjunto);
			}else {
				recursivo(tree.getRight(), n, conjunto);//Solo llamamos al recursivo por la derecha; ya que al ser ordenado,
														//todos los de la izq seran menores que n.
			}
	}
	return conjunto;
}














	
}