package Ejercicios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import us.lsi.tiposrecursivos.Tree;

public class Ejercicio4 {
	public static Set<String> recursivo(Tree<String> tree){
		Set<String> conjuntoPalabras = new HashSet<>();
		List<String> secuenciaCaracteres = new ArrayList<>();
		return recursivo(tree, secuenciaCaracteres, conjuntoPalabras);
	}

	private static Set<String> recursivo(Tree<String> tree, List<String> secuenciaCaracteres, Set<String> conjuntoPalabras) {
		switch(tree.getType()) {
		case Empty:
			break;
		case Leaf:
			secuenciaCaracteres.add(tree.getLabel());
			if(esPalindromo(secuenciaCaracteres)) {
				String palabra = secuenciaCaracteres.stream().collect(Collectors.joining());
				conjuntoPalabras.add(palabra);
			}
			break;
		case Nary:
			secuenciaCaracteres.add(tree.getLabel());
			tree.getChildren().forEach(child -> recursivo(child, new ArrayList<>(secuenciaCaracteres), conjuntoPalabras));
		}
		return conjuntoPalabras;
	}
	
	private static boolean esPalindromo(List<String> palabra) {		
		List<String> invertida = new ArrayList<>();
		for(int i = 0; i < palabra.size(); i++) {
			invertida.add(0, palabra.get(i));
		}
		return palabra.equals(invertida);
	}
}
