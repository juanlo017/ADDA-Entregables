package Ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		return recursivo(tree, map);
	}

	private static Map<Paridad, List<Integer>> recursivo(BinaryTree<Integer> tree, Map<Paridad, List<Integer>> map) {
		switch(tree.getType()) {
		case Empty:
			break;
		case Leaf:
			break;
		case Binary:
			if(!tieneHijosVacios(tree) && mayorQueIzquierdoMenorQueDerecho(tree)) {
				if(tree.getLabel()%2 == 0) {
					if(map.containsKey(Paridad.PAR)) { 
						map.get(Paridad.PAR).add(tree.getLabel());
					}else {
						List<Integer> ls = new ArrayList<>();
						ls.add(tree.getLabel());
						map.put(Paridad.PAR, ls);
					}
				}else{
					if(map.containsKey(Paridad.IMPAR)) { 
						map.get(Paridad.IMPAR).add(tree.getLabel());
					}else {
						List<Integer> ls = new ArrayList<>();
						ls.add(tree.getLabel());
						map.put(Paridad.IMPAR, ls);
					}
				}
			}
			recursivo(tree.getRight(), map);
			recursivo(tree.getLeft(), map);
		}
		return map;
	}
	
	public static Map<Paridad, List<Integer>> funcional(BinaryTree<Integer> tree) {
		Map<Boolean, List<Integer>> m = tree.stream()
											.filter(x -> x.getType().equals(BinaryType.Binary) && !tieneHijosVacios(x) && mayorQueIzquierdoMenorQueDerecho(x))
											.map(x -> x.getLabel())
											.collect(Collectors.partitioningBy(num -> num%2 == 0));
		
		Map<Paridad, List<Integer>> res = new HashMap<>();
		if(m.get(true).size() >= 1) res.put(Paridad.PAR, m.get(true));
		if(m.get(false).size() >= 1) res.put(Paridad.IMPAR, m.get(false));
		
		return res;
	}
		
	private static boolean tieneHijosVacios(BinaryTree<Integer> tree) {
		BinaryType tipoIzquierda = tree.getLeft().getType();
		BinaryType tipoDerecha = tree.getRight().getType();
		return tipoIzquierda.equals(BinaryType.Empty) || tipoDerecha.equals(BinaryType.Empty);
	}

	private static boolean mayorQueIzquierdoMenorQueDerecho(BinaryTree<Integer> tree) {
		Integer valorDer = tree.getRight().getLabel();
		Integer valorIzq = tree.getLeft().getLabel();
		return valorIzq < tree.getLabel() && valorDer > tree.getLabel();
	}	
}
