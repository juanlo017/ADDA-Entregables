package Ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.BinaryTree.BinaryType;

//Diseñe un algoritmo que dado un árbol binario de enteros devuelva un 
//Map<Paridad,List<Integer>> que incluya las etiquetas de los nodos que tengan 2 hijos 
//no vacíos, y que cumplan que dicha etiqueta sea mayor que la etiqueta de su hijo izquierdo 
//y menor que la de su hijo derecho, agrupados teniendo en cuenta si son pares o no. Paridad 
//es un enumerado con los valores Par e Impar. 
public class Ejercicio5 {
	public enum Paridad{PAR, IMPAR};
	
	public static Map<Paridad, List<Integer>> recursiva(BinaryTree<Integer> tree) {
		Map<Paridad, List<Integer>> map = new HashMap<>();
		map.put(Paridad.PAR, new ArrayList<>());
		map.put(Paridad.IMPAR, new ArrayList<>());
		return recursivo(tree, map);
	}

	private static Map<Paridad, List<Integer>> recursivo(BinaryTree<Integer> tree, Map<Paridad, List<Integer>> map) {
		switch(tree.getType()) {
		case Empty:
			break;
		case Leaf:
			break;
		case Binary:
			if(tiene2HijosNoVacios(tree) && mayorQueIzquierdoMenorQueDerecho(tree)) {
				if(tree.getLabel()%2 == 0) {
					map.get(Paridad.PAR).add(tree.getLabel());
				}else {
					map.get(Paridad.IMPAR).add(tree.getLabel());
				}
			}
		}
		return map;
	}

	private static boolean tiene2HijosNoVacios(BinaryTree<Integer> tree) {
		BinaryType tipoIzquierda = tree.getLeft().getType();
		BinaryType tipoDerecha = tree.getRight().getType();
		return !tipoIzquierda.equals(BinaryType.Empty) && !tipoDerecha.equals(BinaryType.Empty);
	}

	private static boolean mayorQueIzquierdoMenorQueDerecho(BinaryTree<Integer> tree) {
		Integer valorIzq = tree.getRight().getLabel();
		Integer valorDer = tree.getLeft().getLabel();
		return valorIzq < tree.getLabel() && valorDer > tree.getLabel();
	}

	public static Map<Paridad, List<Integer>> funcional(BinaryTree<Integer> tree) {
		return null;
	}
	
}
