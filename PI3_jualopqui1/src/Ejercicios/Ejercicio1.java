package Ejercicios;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import us.lsi.tiposrecursivos.Tree;
import us.lsi.tiposrecursivos.Tree.TreeType;


//ordenado: izquierda menores-> derecha mayores
/*
 * Diseñe un algoritmo que dado un árbol n-ario de tipo genérico y un predicado sobre 
	dicho tipo, devuelva un conjunto que contenga las etiquetas de las hojas de dicho árbol 
	que cumplan el predicado.
*/
public class Ejercicio1 {

	public static <E> Set<E> recursivo(Tree<E> tree, Predicate<E> p) {
		return recursivo(tree, p, new HashSet<E>());
	}

	private static <E> Set<E> recursivo(Tree<E> tree, Predicate<E> p, Set<E> conjunto) {
		switch(tree.getType()) {
		case Empty:
			break;
		case Leaf:
			if(p.test(tree.getLabel())) conjunto.add(tree.getLabel());
			break;
		case Nary:
			tree.getChildren().forEach(child -> recursivo(child, p, conjunto));
		}
		return conjunto;
	}
	
	public static<E> Set<E> recursivoFuncional(Tree<E> tree, Predicate<E> p){
		return tree.stream()
					.filter(x-> x.getType().equals(TreeType.Leaf) && !x.isEmpty())
					.map(x -> x.getLabel())
					.filter(label -> p.test(label))
					.collect(Collectors.toSet());
	}	
}
