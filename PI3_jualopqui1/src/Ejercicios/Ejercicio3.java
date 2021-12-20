package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import us.lsi.common.Pair;
import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio3 {

	public static Pair<List<Integer>, Integer> recursivo(BinaryTree<Integer> tree){
		List<Integer> caminoActual = new ArrayList<>();
		List<Integer> caminoMaximo = new ArrayList<>();
		List<Integer> res = recursivo(tree, caminoActual, caminoMaximo);
		return Pair.of(res, res.stream().reduce(1, (x, y) -> x * y));
	}

	private static List<Integer> recursivo(BinaryTree<Integer> tree,List<Integer> caminoActual, List<Integer> caminoMaximo) {
		switch(tree.getType()) {
		case Empty:
			break;
		case Leaf:
			caminoActual.add(tree.getLabel());
			if(ActualMayorQueMaximo(caminoActual, caminoMaximo)) {
				caminoMaximo = new ArrayList<>();
				caminoMaximo.addAll(caminoActual);
			} 
			break;
		case Binary:
			caminoActual.add(tree.getLabel());
			caminoMaximo = recursivo(tree.getRight(), new ArrayList<>(caminoActual), caminoMaximo);
			caminoMaximo = recursivo(tree.getLeft(), new ArrayList<>(caminoActual), caminoMaximo);
		}
		return caminoMaximo;
	}

	private static boolean ActualMayorQueMaximo(List<Integer> caminoActual, List<Integer> caminoMaximo) {
		Integer productoActual = caminoActual.stream().reduce(1, (x, y) -> x * y);
		Integer productoMaximo = caminoMaximo.stream().reduce(1, (x, y) -> x * y);
		return productoActual >= productoMaximo;
	}	
}
